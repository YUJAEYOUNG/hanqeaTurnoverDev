package egovframework.example.cmmn.webSocket;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.example.login.service.LoginVO;
import egovframework.example.webChat.dao.ChatDAO;
import egovframework.example.webChat.service.ChatRoomVO;

public class WebSocketHandler extends TextWebSocketHandler{

	private static Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
	private List<WebSocketSession> wbSessionList = new ArrayList<WebSocketSession>();
	
	@Autowired
	private ChatDAO chatDao;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		logger.info("{} 접속," );
		wbSessionList.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("{} 종료");
		wbSessionList.remove(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		String openWebChatId = (String) session.getAttributes().get("openWebChatId");
		List<ChatRoomVO> getChatJoinUser = chatDao.getChatJoinUser(openWebChatId);
		
		LoginVO usrInfo = (LoginVO)session.getAttributes().get("loginVO");
		
		ChatRoomVO logParam = new ChatRoomVO();
		
		String writer = usrInfo.getUserNick()+" ("+usrInfo.getUserNm()+")";
		//채팅 로그 작성
		logParam.setChatRoomId(openWebChatId);
		logParam.setChatMessage(message.getPayload());
		logParam.setChatWriter(usrInfo.getUserId());
		chatDao.insetChat(logParam);

		for ( WebSocketSession sess : wbSessionList ) {
			for ( ChatRoomVO param : getChatJoinUser ) {

				if ( param.getChatUserEmail().equals(usrInfo.getUserId())){
					
					sess.sendMessage(new TextMessage(usrInfo.getUserId()+ " | " + message.getPayload()+ " | " + openWebChatId+ " | " + writer));
				}
			}
		}
	}
	
}
