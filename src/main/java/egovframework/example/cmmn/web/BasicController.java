package egovframework.example.cmmn.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import egovframework.example.cmmn.util.SessionUtil;
import egovframework.example.login.service.LoginVO;

/**
 * ========================================
 * 작성자       | 유재영
 * 최초생성일   | 2018-08-03
 * 페이지       | BasicController.java
 * 설명         | 공통(기본) 메소드 작업
 * ========================================
 */
public class BasicController {
	private static final Logger LOGGER 			= Logger.getLogger("CmmnController");
	
	public static final HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attributes.getRequest();
	}
	
	/**
	 * 
	 * @Method Name : getLoginInfo
	 * @작성일 		: 2018-08-27
	 * @작성자		: 유재영
	 * @Method 설명	: 세션정보 VO 형태로 공통 가져오기 (!! 안돼자나 !!)
	 * @param obj
	 * @return
	 */
	@ModelAttribute("loginVO")
	public LoginVO getLoginInfo() throws Exception {
		return SessionUtil.getLoginVODataToVO();
	}
	
	/**
	 * 
	 * @Method Name : ObjectToString
	 * @작성일 		: 2018-08-03
	 * @작성자		: 유재영
	 * @Method 설명	: String 타입캐스팅
	 * @param obj
	 * @return
	 */
	public static String ObjectToString(Object obj) {
		return (String) obj;
	}
	
	/**
	 * 
	 * @Method Name : ObjectToMap
	 * @작성일 		: 2018-08-03
	 * @작성자		: 유재영
	 * @Method 설명	: Map<String, Object> 타입캐스팅
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> ObjectToMap(Object obj) {
		return (Map<String, Object>) obj;
	}
	
	/**
	 * 
	 * @Method Name : ObjectToList
	 * @작성일 		: 2018-08-03
	 * @작성자		: 유재영
	 * @Method 설명	: List<Map<String, Object>> 타입캐스팅
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> ObjectToList(Object obj) {
		return (List<Map<String, Object>>) obj;
	}
	
}
