package egovframework.example.webChat.web;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import egovframework.example.join.service.JoinVO;
import egovframework.example.login.service.LoginVO;
import egovframework.example.webChat.service.ChatRoomVO;
import egovframework.example.webChat.service.WebChatService;

/**
 * ========================================
 * 작성자       | 정종문
 * 최초생성일  | 2018-09-08
 * 페이지       | WebChatController.java
 * 설명          | 웹 채팅 컨트롤러
 * ========================================
 */
@Controller
@RequestMapping(value="/webChat")
public class WebChatController {
	
	@Resource
	private WebChatService webChatService;

	private static Logger logger = LoggerFactory.getLogger(WebChatController.class);
	
	private static ObjectMapper objMap = new ObjectMapper();
	
	/**
		 * ========================================
		 * 작성자 | 정종문 
		 * 설명   | 웹 채팅 목록 페이지 이동.
		 * ========================================
		 */
	@RequestMapping(value="/community.do")
	public String initWebChatMain() throws Exception{
		
		return "webChat/webChatList.tiles";
	}
	
	
	/**
		 * ========================================
		 * 작성자 | 정종문 
		 * 설명   | 웹 채팅방 입장.
		 * ========================================
		 */
	@RequestMapping(value="/chatRoom.do")
	public String initWebChatRoom(HttpServletRequest request, ModelMap model) throws Exception{
		logger.info("== {} 호출 == " , "chatRoom.do");
		String chatId = request.getParameter("openChatId");
		model.addAttribute("openChatId",chatId);
		return "webChat/webChatRoom.tiles";
	}
	
	/**
	 * ========================================
	 * 작성자 | 정종문 
	 * 설명   | 웹 채팅방 입장.
	 * ========================================
	 */
	@RequestMapping(value="/getChatLog.do")
	public @ResponseBody Object getChatLog(HttpServletRequest reqeust) throws Exception{
		logger.info("== {} 호출 == " , "getChatLog.do");
		String chatId= (String)reqeust.getParameter("openChatId");
		logger.info("RESULT == {}", chatId );
		
		reqeust.getSession().setAttribute("openWebChatId", chatId);
		
		List<ChatRoomVO> chatLogList = webChatService.getChatLogList(chatId);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("chatLogList", chatLogList);
		return resultMap;
}
	
	/**
		 * ========================================
		 * 작성자 | 정종문 
		 * 설명   | 채팅방 참여 인원 추가를 위한 회원 검색.
		 * ========================================
		 */
	@RequestMapping(value="/getMember.do", produces="application/json; charset=UTF-8")
	public @ResponseBody Object getMember( HttpServletRequest reqeust, 
			@RequestParam(value="searchUser") String p_searchUser) throws Exception{
		logger.info("== {} 호출 == " , "getMember.do");
		
		LoginVO loginInfo = (LoginVO) reqeust.getSession().getAttribute("loginVO");
		
		Map<String, Object> paramsMap = new HashMap<>();
		paramsMap.put("searchUser", p_searchUser);
		paramsMap.put("sessionUserId", loginInfo.getUserId());
		ObjectMapper mapp = new ObjectMapper();
		List<JoinVO> memberList = webChatService.getMember(paramsMap);
		logger.info("== RESULT {}",mapp.writeValueAsString(memberList) );
		
		Gson gson = new Gson();
		
		return gson.toJson(memberList);
	}
	
	/**
		 * ========================================
		 * 작성자 | 정종문 
		 * 설명   | 채팅 방 생성.
		 * ========================================
		 */
	@RequestMapping(value="/createChatRoom.do", method = RequestMethod.POST, produces="application/json",consumes="application/json" )
	public @ResponseBody Object createChatRoom(@RequestBody List< Map<String, Object> > params,
			HttpServletRequest request) throws Exception{
		logger.info("== {} 호출 ==", "createChatRoom.do");
		
		LoginVO sessionUsrInfo = (LoginVO)request.getSession().getAttribute("loginVO");
		Map<String, Object> sessionMap = new HashMap<>();
		sessionMap.put("userId",   sessionUsrInfo.getUserId());
		sessionMap.put("userNm",   sessionUsrInfo.getUserNm());
		sessionMap.put("userNick", sessionUsrInfo.getUserNick());
		params.add(sessionMap);
		
		webChatService.createChatRoom(params);
		
		Gson gson = new Gson();
		
		return gson.toJson("success");
	}
	
	@RequestMapping(value="/getChatRoomList.do")
	public @ResponseBody Object getWebChatList(HttpServletRequest request) throws Exception{
		logger.info("== {} 호출 ==", "getChatRoomList.do");
		
		LoginVO sessionUsrInfo = (LoginVO)request.getSession().getAttribute("loginVO");
		String usrId = (String)sessionUsrInfo.getUserId();
		
		List<ChatRoomVO> getChatRoomList = webChatService.getWebChatList(usrId);
		
		return getChatRoomList;
	}
	
}
