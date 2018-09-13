<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../cmmn/taglib.jsp"/>

<script type="text/javascript">
	$(document).ready(function(){
		
		//채팅 방 출력
		webChat.getChatRoomList();
		
		//searchUser
		$("#searchMemberBtn").on("click", function(){
			var searchUser = $("#searchUser").val();
			memberAction.getMember(searchUser);
		})
		
		//make Chat Romm
		$("#makeChatRoomBtn").on("click", function(){
			
			webChat.makeChatRoom();
		})
		
		$("#").on("dblclick", function(){
			
			
		})
		
		
	})
	
	function joinUserAdd(obj){
		
		var td= $(obj).children();
		
		if ( td.eq(0).text() == "No Data" || td.eq(0).text() == "") {
			alert("조회 된 유저가 없습니다.");
			return false;
		}

		var data = {
						"mberId":td.eq(0).text(),
						"mberNm":td.eq(1).text(),
						"mberNick":td.eq(2).text()
					};
		
		// 추가 된 참여 유저 부분에 중복 된 값 체크.
		var joinUsrTd = $("#joinUsrBody").children().find("td").eq(0).text();
		
		var cnt = 0;
		
		var flag = false;
		
		$($("#joinUsrBody").children()).each(function(i){
			
			if ( data.mberId == $("#joinUsrBody").children().find("td").eq(cnt).text() ) {
				
				flag = true;
				return false;
			}
			
			cnt+=3;
		})
		
		if ( flag == false ) {
			
			var resultHtml = "<tr ondblclick=\"javascript:joinUsrRemove(this);\">";
				resultHtml += "<td>"+data.mberId+"</td>";
				resultHtml += "<td>"+data.mberNm+"</td>";
				resultHtml += "<td>"+data.mberNick+"</td>";
			    resultHtml += "</tr>";
			$("#joinUsrBody").append(resultHtml);
		} else {
			
			alert("선택 된 유저는 이미 추가 된 유저입니다.");
		}
	}
	
	function joinUsrRemove(obj){
		$(obj).remove();
	}
	
	function initChatRoom(p_openChatId){
		$("#openChatId").val(p_openChatId);
		$("#chatForm").submit();
	}
</script>
	
	<div class="row">
			
		<!-- Listings -->
		<div class="col-lg-12 col-md-12">

			<div class="messages-container margin-top-0">
				<div class="messages-headline">
					<h4>채팅방 목록</h4>
					<!-- <h4>채팅방 개설</h4>
					<button class="im im-icon-Search-People" id="chatMakeBtn"></button> -->
				</div>
				
				<div class="messages-inbox" id="webChatList">
					<!-- <ul> -->
						<!-- <li>
							<div class="message-by">
								<p align="center">생성 된 대화가 없습니다.</p>
							</div>
						</li> -->
<!-- 						<li class="unread">
							<a href="/webChat/chatRoom.do">
								<div class="message-avatar">
									<img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt="">
								</div>
								<div class="message-by">
									<div class="message-by-headline">
										<h5>Kathy Brown <i>Unread</i></h5>
										<span>2 hours ago</span>
									</div>
									<p>Hello, I want to talk about your great listing! Morbi velit eros, sagittis in facilisis non, rhoncus posuere ultricies...</p>
								</div>
							</a>
						</li> -->
					<!-- </ul> -->
				</div>
			</div>
			<!-- Pagination -->
			<div class="clearfix"></div>
			<div class="pagination-container margin-top-30 margin-bottom-0">
				<nav class="pagination">
					<ul>
						<li><a href="#" class="current-page">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#"><i class="sl sl-icon-arrow-right"></i></a></li>
					</ul>
				</nav>
			</div>
			<!-- Pagination / End -->
		</div>
	</div>
	
	<div class="row">
		<div class="col-lg-12 col-md-12">
			<div class="messages-container margin-top-0">
				<div class="messages-headline">
					<h4>참여 유저 검색</h4>
						<input type="text" id="searchUser" placeholder="Search User...">
						<button class="im im-icon-Search-People" id="searchMemberBtn"></button>
				</div>
				
				<div class="col-lg-6 col-md-12 margin-top-10">
					<div class="dashboard-list-box margin-top-0">
						<h4>User Search Result <span style="color: red;"> * 해당 유저 더블클릭 시 참여인원 추가.</span></h4>
						<table class="margin-top-20">
							<thead>
								<tr>
									<th>아이디</th>
									<th>이름</th>
									<th>닉네임</th>
								</tr>
							</thead>
							<tbody id="searchUsrResultBody">
							</tbody>
						</table>
					</div>
					<button id="makeChatRoomBtn" class="button add-pricing-list-item">Make ChatRoom</button>
				</div>
				
				<div class="col-lg-6 col-md-12 margin-top-10">
					<div class="dashboard-list-box margin-top-0">
						<h4>채팅방 참여 유저 <span style="color: red;"> * 해당 유저 더블클릭 시 참여인원 제외.</span></h4>
						<table class="margin-top-20">
							<thead>
								<tr>
									<th>아이디</th>
									<th>이름</th>
									<th>닉네임</th>
								</tr>
							</thead>
							<tbody id="joinUsrBody">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<form action="/webChat/chatRoom.do" id="chatForm" name="chatForm" method="post">
		<input id="openChatId" name="openChatId" type="hidden" value="">
	</form>
