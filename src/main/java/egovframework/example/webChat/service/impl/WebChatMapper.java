package egovframework.example.webChat.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.example.join.service.JoinVO;
import egovframework.example.webChat.service.ChatRoomVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper(value="webChatMapper")
public interface WebChatMapper {

	public List<JoinVO> getMember(Map<String, Object> paramsMap) throws Exception;
	
	public void insertChatRoom(ChatRoomVO param) throws Exception;
	
	public void insertChatRoomOption(ChatRoomVO param) throws Exception;
	
	public void insertChatRoomJoinUser(ChatRoomVO param) throws Exception;
	
	public List<ChatRoomVO> getWebChatList(String param) throws Exception;
	
	public List<ChatRoomVO> getChatJoinUser(String p_openWebChatId) throws Exception;
	
	public List<ChatRoomVO> getChatLogList(String p_chatRoomId) throws Exception;
}
