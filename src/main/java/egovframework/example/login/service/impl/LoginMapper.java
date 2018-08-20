package egovframework.example.login.service.impl;

import java.util.Map;

import egovframework.example.login.service.LoginVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("loginMapper")
public interface LoginMapper {
	
	/**
	 * ========================================
	 * 작성자   | 유재영 
	 * 설명     | 로그인 처리
	 * ========================================
	 */
	LoginVO selectLoginUsr(Map<String, Object> hmap) throws Exception; 

}
