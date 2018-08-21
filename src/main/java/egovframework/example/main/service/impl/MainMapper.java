package egovframework.example.main.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * ========================================
 * 작성자       | 유재영
 * 최초생성일   | 2018-08-13
 * 페이지       | MainMapper.java
 * 설명         | 메인 매퍼
 * ========================================
 */
@Mapper("mainMapper")
public interface MainMapper {
	
	/**
	 * ========================================
	 * 작성자 | 유재영 
	 * 설명   | 메뉴 리스트 가져오기(최상위)
	 * ========================================
	 */
	List<Map<String, Object>> selectMainMenuList() throws Exception;
	
	/**
	 * ========================================
	 * 작성자 | 유재영 
	 * 설명   | 서브메뉴 리스트 가져오기
	 * ========================================
	 */
	List<Map<String, Object>> selectSubMenuList(String menuId) throws Exception;

}
