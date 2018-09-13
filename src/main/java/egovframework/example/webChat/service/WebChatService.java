package egovframework.example.webChat.service;

import java.util.List;
import java.util.Map;

import egovframework.example.join.service.JoinVO;

public interface WebChatService {

	/**
		 * ========================================
		 * 작성자 | 정종문 
		 * 설명   | 채팅 방 개설을 위한 참여 회원 정보.
		 * ========================================
		 */
	public List<JoinVO> getMember(Map<String, Object> paramsMap ) throws Exception;
	
	
	/**
		 * ========================================
		 * 작성자 | 정종문 
		 * 설명   | 채팅 방 개설. 
		 * ========================================
		 */
	public void createChatRoom(List< Map<String, Object> > params ) throws Exception;
	
	
	/**
		 * ========================================
		 * 작성자 | 정종문 
		 * 설명   | 개설 된 채팅방 목록 출력
		 * ========================================
		 */
	public List<ChatRoomVO> getWebChatList(String param ) throws Exception;
	
	
	/**
		 * ========================================
		 * 작성자 | 정종문 
		 * 설명   | 채팅 기록 출력
		 * ========================================
		 */
	public List<ChatRoomVO> getChatLogList(String p_chatRoomId) throws Exception;
}
