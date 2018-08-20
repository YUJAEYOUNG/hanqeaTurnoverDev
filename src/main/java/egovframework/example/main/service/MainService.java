package egovframework.example.main.service;

import java.util.List;
import java.util.Map;

/**
 * ========================================
 * 작성자       | 유재영
 * 최초생성일   | 2018-08-13
 * 페이지       | MainService.java
 * 설명         | 메인 인터페이스
 * ========================================
 */
public interface MainService {
	
	/**
	 * ========================================
	 * 작성자 | 유재영 
	 * 설명   | 메뉴 리스트 가져오기(최상위)
	 * ========================================
	 */
	List<Map<String, Object>> selectMainMenuList() throws Exception;

}
