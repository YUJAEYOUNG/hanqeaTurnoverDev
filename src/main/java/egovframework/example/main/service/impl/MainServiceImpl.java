package egovframework.example.main.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.main.service.MainService;

/**
 * ========================================
 * 작성자       | 유재영
 * 최초생성일   | 2018-08-13
 * 페이지       | MainServiceImpl.java
 * 설명         | 메인 인터페이스 구현체
 * ========================================
 */
@Service("mainService")
public class MainServiceImpl implements MainService {
	
	@Resource(name = "mainMapper")
	private MainMapper mainMapper;
	
	/**
	 * ========================================
	 * 작성자 | 유재영 
	 * 설명   | 메뉴 리스트 가져오기(최상위)
	 * ========================================
	 */
	@Override
	public List<Map<String, Object>> selectMainMenuList() throws Exception {
		return mainMapper.selectMainMenuList();
	}
	
	/**
	 * ========================================
	 * 작성자 | 유재영 
	 * 설명   | 서브메뉴 리스트 가져오기
	 * ========================================
	 */
	@Override
	public List<Map<String, Object>> selectSubMenuList(String menuId) throws Exception {
		return mainMapper.selectSubMenuList(menuId);
	}

}
