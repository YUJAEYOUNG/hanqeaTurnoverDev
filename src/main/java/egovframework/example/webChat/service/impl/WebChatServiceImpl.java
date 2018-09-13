package egovframework.example.webChat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.join.service.JoinVO;
import egovframework.example.webChat.service.ChatRoomVO;
import egovframework.example.webChat.service.WebChatService;

@Service(value="webChatService")
public class WebChatServiceImpl implements WebChatService{
	
	@Resource
	private WebChatMapper webChatMapper;

	@Override
	public List<JoinVO> getMember(Map<String, Object> paramsMap) throws Exception {
		
		return webChatMapper.getMember(paramsMap);
	}

	@Override
	public void createChatRoom(List<Map<String, Object>> params) throws Exception {
		
		String chatRoomId = "chat"+UUID.randomUUID().toString().replaceAll("-", "").toUpperCase().substring(0, 11);
		ChatRoomVO vo = new ChatRoomVO();
		
		vo.setChatRoomId( chatRoomId );
		
		List<String> tempList = new ArrayList<>();
		
		for (Map<String, Object> data : params) {
			
			tempList.add( (String) data.get("userId") );
		}
		
		//ChatRoom 개설
		webChatMapper.insertChatRoom(vo);
		String tempChatName = "";
		for ( int i = 0; i < tempList.size(); i++ ) {
			tempChatName+= tempList.get(i).substring(0, tempList.get(i).indexOf("@"));
			if(i != (tempList.size()-1) )tempChatName+=", ";
		}
		//String chatName = tempList.size() > 2 ? tempList.get(0)+" 외 "+ (tempList.size()-1) +"명" : tempList.get(1)+" 채팅방";
		String chatName = tempList.size() > 2 ? tempList.get(0)+" 외 "+ (tempList.size()-1) +"명" : tempChatName+" 채팅방";
		vo.setChatName(chatName);
		vo.setChatParticipantCnt(tempList.size());
		
		//ChatRoom 관련 설정 정보 
		webChatMapper.insertChatRoomOption(vo);
		
		//ChatRoom 참여 인원 작성
		for ( String emailVal : tempList ) {
			vo.setChatUserEmail(emailVal);
			webChatMapper.insertChatRoomJoinUser(vo);
		}
	}

	@Override
	public List<ChatRoomVO> getWebChatList(String param) throws Exception {
		return webChatMapper.getWebChatList(param);
	}

	@Override
	public List<ChatRoomVO> getChatLogList(String p_chatRoomId) throws Exception {
		return webChatMapper.getChatLogList(p_chatRoomId);
	}

}
