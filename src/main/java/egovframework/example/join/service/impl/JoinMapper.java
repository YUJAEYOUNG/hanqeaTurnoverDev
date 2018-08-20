package egovframework.example.join.service.impl;

import egovframework.example.join.service.JoinVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * ========================================
 * 작성자       | 유재영
 * 최초생성일   | 2018-08-03
 * 페이지       | JoinMapper.java
 * 설명         | 회원가입
 * ========================================
 */
@Mapper("joinMapper")
public interface JoinMapper {
	
	/**
	 * ========================================
	 * 작성자   | 유재영 
	 * 설명     | 회원가입 후 로그인 페이지 이동
	 * ========================================
	 */
	void insertMber(JoinVO joinVO) throws Exception;

}
