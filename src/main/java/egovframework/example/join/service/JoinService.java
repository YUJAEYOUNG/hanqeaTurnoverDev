package egovframework.example.join.service;

/**
 * ========================================
 * 작성자       | 유재영
 * 최초생성일   | 2018-08-03
 * 페이지       | JoinService.java
 * 설명         | 회원가입
 * ========================================
 */
public interface JoinService {
	
	/**
	 * ========================================
	 * 작성자   | 유재영 
	 * 설명     | 회원가입 후 로그인 페이지 이동
	 * ========================================
	 */
	void insertMber(JoinVO joinVO) throws Exception;

}
