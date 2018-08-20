package egovframework.example.cmmn.util;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import egovframework.example.login.service.LoginVO;

/**
 * ========================================
 * 작성자       | 유재영 
 * 최초생성일   | 2018-08-10
 * 페이지       | SessionUtil.java
 * 설명         | Session 유틸 관리 
 * ========================================
 */
public class SessionUtil {
	
	private static final String SESSION_DATA_KEY 	= "loginVO";
	
	public static final HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attributes.getRequest();
    }
	
	/**
	 * LoginVO 정보를 가져온다.
	 *
	 * @param  request
	 * @return LoginVO
	 * @see LoginVO
	 */
	public static LoginVO getLoginVODataToVO() {
		return (LoginVO) getData(SESSION_DATA_KEY);
	}
	
	/**
	 * LoginVO 정보를 가져온다.
	 *
	 * @param  request
	 * @return LoginVO >> toMap
	 * @see LoginVO
	 */
	public static Map<String, Object> getLoginVODataToMap() {
		return ReflectionUtil.beanToMap((LoginVO) getData(SESSION_DATA_KEY));
	}

	/**
	 * SessionData 를 LoginVO 에 저장한다.
	 *
	 * @param request
	 * @param sessionData
	 * @see LoginVO
	 */
	public static void setLoginVOData(LoginVO loginVO) {
		setData(SESSION_DATA_KEY, loginVO);
	}

	/**
	 * session 에서 key 이름으로 저장된 data를 가져온다.
	 *
	 * @param  request
	 * @param  key
	 * @return SessionData
	 */
	public static Object getData(String key) {
		return getRequest().getSession().getAttribute(key);
	}

	/**
	 * session 에 key 이름으로 data 를 저장한다.
	 *
	 * @param request HttpServletRequest
	 * @param key session key value
	 * @param data object
	 */
	public static void setData(String key, Object data) {
		if(key != null && data != null) {
			getRequest().getSession().setAttribute(key, data);
		}
	}

	/**
	 * session 에 key 이름으로 등록된 data 를 삭제한다.
	 *
	 * @param request
	 * @param key
	 */
	public static void removeData(String key) {
		getRequest().getSession().removeAttribute(key);
	}

	/**
	 * session 에 key(loginVO) 이름으로 등록된 data 를 삭제한다.
	 *
	 * @param request
	 * @param key
	 */
	public static void removeSession(){
		getRequest().getSession().removeAttribute(SESSION_DATA_KEY);

		getRequest().getSession().invalidate();
	}
	
}
