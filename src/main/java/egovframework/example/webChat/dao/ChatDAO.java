package egovframework.example.webChat.dao;

import java.util.List;

import egovframework.example.webChat.service.ChatRoomVO;


public interface ChatDAO {
	
	public List<ChatRoomVO> getChatJoinUser(String p_openWebChatId) throws Exception;
	
	public void insetChat(ChatRoomVO param) throws Exception; 

}
