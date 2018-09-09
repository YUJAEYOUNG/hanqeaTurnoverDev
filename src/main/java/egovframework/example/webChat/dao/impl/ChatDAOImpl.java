package egovframework.example.webChat.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.example.webChat.dao.ChatDAO;
import egovframework.example.webChat.service.ChatRoomVO;

@Repository
public class ChatDAOImpl implements ChatDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final String NAME_SAPCE = "egovframework.example.webChat.service.impl.WebChatMapper";
	
	@Override
	public List<ChatRoomVO> getChatJoinUser(String p_openWebChatId) throws Exception {
		
		return sqlSession.selectList(NAME_SAPCE+".getChatJoinUser", p_openWebChatId);
	}

	@Override
	public void insetChat(ChatRoomVO param) throws Exception {
		sqlSession.insert(NAME_SAPCE+".insertChat", param);
	}

}
