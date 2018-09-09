<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../cmmn/taglib.jsp"/>
<script type="text/javascript" src="/js/custom/jjm.js"></script>

<script type="text/javascript">
	
	$(document).ready(function(){
		
		//채팅 로그 가져오기
		webChat.getChatLog('${openChatId}');
		
		$("#msgSendBtn").on("click", function(){
			webChat.sendMessage();
		})
		
	});

</script>

	<div class="row">
		<!-- Listings -->
		<div class="col-lg-12 col-md-12">

			<div class="messages-container margin-top-0">
				<div class="messages-headline">
					<h4>Kathy Brown</h4>
					<a href="#" class="message-action"><i class="sl sl-icon-trash"></i> Delete Conversation</a>
				</div>

				<div class="messages-container-inner">

					<!-- Messages -->
					<div class="messages-inbox">
						<ul style="max-height: 1141px;">
							<li class="active-message">
								<a href="dashboard-messages-conversation.html">
									<div class="message-avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt=""></div>

									<div class="message-by">
										<div class="message-by-headline">
											<h5>Kathy Brown</h5>
											<span>2 hours ago</span>
										</div>
										<p>Hello, I want to talk about your great listing! Morbi velit eros, sagittis in facilisis non, rhoncus et erat. Nam posuere tristique sem, eu ultricies tortor lacinia neque imperdiet vitae...</p>
									</div>
								</a>
							</li>
						</ul>
					</div>
					<!-- Messages / End -->

					<!-- Message Content -->
					<div class="message-content">
						<div id="messageView">
<!-- 							<div class="message-bubble">
								<div class="message-avatar"><img src="http://www.gravatar.com/avatar/00000000000000000000000000000000?d=mm&amp;s=70" alt=""></div>
								<div class="message-text"><p>Hello, I want to talk about your great listing! Morbi velit eros, sagittis in facilisis non, rhoncus et erat. Nam posuere tristique sem, eu ultricies tortor lacinia neque imperdiet vitae.</p></div>
							</div>
	
							<div class="message-bubble me">
								<div class="message-avatar"><img src="/images/dashboard-avatar.jpg" alt=""></div>
								<div class="message-text"><p>Nam ut hendrerit orci, ac gravida orci. Cras tristique rutrum libero at consequat. Vestibulum vehicula neque maximus sapien iaculis, nec vehicula sapien fringilla.</p></div>
							</div> -->
						</div>
						
						<!-- Reply Area -->
						<div class="clearfix"></div>
						<div class="message-reply">
							<textarea cols="40" rows="3" placeholder="Your Message" id="writeMessage"></textarea>
							<button class="button" id="msgSendBtn">Send Message</button>
							<input type="hidden" id="sessionId" value="${sessionScope.loginVO.userId}"/>
						</div>
						
					</div>
					<!-- Message Content -->
				</div>
			</div>
		</div>
	</div>