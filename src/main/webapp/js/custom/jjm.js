
/*
 * ============ JS for Modal ==============
 */
/*var modalAction = {
		
		openModal : function(p_modalId) {
			alert('1'+p_modalId);
			$("#"+p_modalId).modal();
		}
}*/
// ==============================================


/*
 * ============ JS for Member ==============
 */

var memberAction = {
		
		getMember : function(p_searchUser){
			$.ajax({
				url         : "/webChat/getMember.do",
				data        : {"searchUser" : p_searchUser},
				dataType :"json",
				success : function(res){
					var resultHtml= "";
					if ( res.length > 0 ) {
						
						$.each( res, function(i,val){
							resultHtml += "<tr ondblclick=\"javascript:joinUserAdd(this);\">";
							resultHtml += "    <td>"+val.mberId+"</td>";
							resultHtml += "    <td>"+val.mberNm+"</td>";
							resultHtml += "    <td>"+val.mberNick+"</td>";
							resultHtml += "</tr>";
						})
					} else {
						resultHtml = '<tr><td colspan="3" style="text-align: center;">No Data</td>';
					}
					$("#searchUsrResultBody").html(resultHtml);
				},
				error : function(err){
					alert('error');
				}
			})
		}
}
// ==============================================


/*
 * ============ JS for WebSocket ==============
 */

var webChat = {
		
		sock : "",
		openChatId : "",
		/*
		 * 채팅방 개설.
		 */
		makeChatRoom : function(){
			
			var tdArr = new Array();
			var td = $("#joinUsrBody").children().find('td');
			var objArr = new Array();
			var tempStr = "";
			var tempCnt = 1;
			td.each(function(index){
				
				if ( index % 3 != 0  ) {
					tempStr += ","+td.eq(index).text();
				} else {
					tempStr += td.eq(index).text();
				}
				
				if ( tempCnt % 3 ==0 && td.eq(index+1).text() != "" )tempStr+="/";
				tempCnt++;
			})
			
			var tempArr = tempStr.split("/");
			for ( var i = 0; i < tempArr.length; i++ ) {
				
				var tempSplit = tempArr[i].split(",");
				var obj = new Object();
				obj.userId = tempSplit[0];
				obj.userNm = tempSplit[1];
				obj.userNick = tempSplit[2];
				objArr.push(obj);
				
			}
			
			$.ajax({
				url		:	"/webChat/createChatRoom.do",
				method	:	"post",
				data    :   JSON.stringify(objArr),
				dataType:	"json",
				contentType : "application/json",
				success : function(result){
					alert('채팅방 개설 완료');
				},
				error	: function(error){
					alert('error');
				}
			})
		},
		/*
		 * 개설 된 채팅 방 목록 출력
		 */
		getChatRoomList : function(){
			$.ajax({
				url		:	"/webChat/getChatRoomList.do",
				success	: function(result) {
					
					var resultHtml ="";
					console.log(JSON.stringify(result));
					resultHtml +="<ul>"
					if ( result.length > 0 ) {
						
						$.each(result, function(index, value){
							
							resultHtml += "<li class=\"unread\">							";
							resultHtml += "		<a href=\"#\" onclick=\"javascript:initChatRoom('"+value.chatRoomId+"');\">	";
							resultHtml += "			<div class=\"message-avatar\">			";
							resultHtml += "				<img src=\"http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70\" alt=\"Default Img\">";
							resultHtml += "			</div>									";
							resultHtml += "			<div class=\"message-by\">				";
							resultHtml += "				<div class=\"message-by-headline\">	";
							resultHtml += "					<h5>"+value.chatName+" <i>Unread</i></h5>		";
							resultHtml += "					<span>1 hours ago</span>		";
							resultHtml += "				</div>								";
							resultHtml += "				<p>Message By......</p>				";
							resultHtml += "			</div>									";
							resultHtml += "		</a>										";
							resultHtml += "</li>											";
						})
					} else {
						
						resultHtml +="<li>                                            ";
						resultHtml +="	<div class=\"message-by\">                    ";
						resultHtml +="		<p align=\"center\">생성 된 대화가 없습니다.</p>  ";
						resultHtml +="	</div>                                        ";
						resultHtml +="</li>                                           ";
					}
					resultHtml +="</ul>"
					$("#webChatList").html(resultHtml);
				},
				error 	: function(error) {
					alert("error");
				}
			})
		},
		
		/*
		 * Chat 로그 출력
		 */
		getChatLog : function(p_openChatId) {
			
			//openChatId 저장
			$.ajax({
				 url		:	"/webChat/getChatLog.do"
				,data		:	{ "openChatId" : p_openChatId}
				,success  : function(result){
					
					$("#messageView").html('');
					console.log(JSON.stringify(result.chatLogList[0]));
					if ( result.chatLogList.length > 0 ) {
						
						var printHtml = "";
						$.each(result.chatLogList, function(index,value){
							
							if ( value.chatWriter.trim() == $("#sessionId").val().trim() ) {
								
								printHtml+= "<div class=\"message-bubble me\">";
								printHtml+= "	<div class=\"message-avatar\"><img src=\"/images/dashboard-avatar.jpg\" alt=\"\"></div>";
								printHtml+= "	<div class=\"message-text\"><p>"+value.chatMessage+"<p></div>";
								printHtml+= "</div>";
								
							} else{
								
								printHtml+= "<div class=\"message-bubble\">";
								printHtml+= "	<div class=\"message-avatar\"><img src=\"http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70\" alt=\"\"></div>";
								printHtml+= "	<div class=\"message-text\"><p>"+value.userNick+" ("+value.userNm+")</p><p>"+value.chatMessage+"<p></div>";
								printHtml+= "</div>";
							}
						})
						
						$("#messageView").html(printHtml);
					}
				}
			})
			this.openChatId = p_openChatId;
			webChat.ready();
			
		},
		
		
		/*
		 * Chat 준비
		 */
		ready: function() {
			this.sock = new SockJS("/webSocket");
			this.sock.onmessage = this.onMessage;
		},
		
		/*
		 * 메시지 전송
		 */
		sendMessage : function() {
			
			this.sock.send( $("#writeMessage").val());
		},
		
		/*
		 * 메시지 내용 출력
		 */
		onMessage   : function(evt) {
			var data = evt.data;
			var sessionid = null;
			var message = null;
			var writer = null;
			
			var strArray = data.split("|");
			
			if ( webChat.openChatId == strArray[2].trim() ){
				
				var currentuser_session =  $("#sessionId").val();
				
				sessionid = strArray[0];
				message = strArray[1];
				writer = strArray[3];
				
				var printHtml = "";
				if ( sessionid.trim() == currentuser_session.trim() ) {
					printHtml = "<div class=\"message-bubble me\">";
					printHtml+= "	<div class=\"message-avatar\"><img src=\"/images/dashboard-avatar.jpg\" alt=\"\"></div>";
					printHtml+= "	<div class=\"message-text\"><p>"+message+"<p></div>";
					printHtml+= "</div>";
				} else {
					printHtml = "<div class=\"message-bubble\">";
					printHtml+= "	<div class=\"message-avatar\"><img src=\"http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70\" alt=\"\"></div>";
					printHtml+= "	<div class=\"message-text\"><p>"+writer+"</p><p>"+message+"<p></div>";
					printHtml+= "</div>";
				}
				$("#messageView").append(printHtml);
			}
			
		},
		
		connectClose : function(){
			this.sock.close();
		}
}
//==============================================

