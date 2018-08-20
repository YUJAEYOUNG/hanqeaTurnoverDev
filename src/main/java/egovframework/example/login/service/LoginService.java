package egovframework.example.login.service;

public interface LoginService {
	
	/**
	 * ========================================
	 * 작성자   | 유재영 
	 * 설명     | 로그인 처리
	 * ========================================
	 */
	LoginVO selectLoginUsr(String id, String password) throws Exception;

}
