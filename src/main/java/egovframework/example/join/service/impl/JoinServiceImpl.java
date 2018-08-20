package egovframework.example.join.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.cmmn.EgovFileScrty;
import egovframework.example.cmmn.web.BasicController;
import egovframework.example.join.service.JoinService;
import egovframework.example.join.service.JoinVO;

/**
 * ========================================
 * 작성자       | 유재영
 * 최초생성일   | 2018-08-03
 * 페이지       | JoinServiceImpl.java
 * 설명         | 회원가입
 * ========================================
 */
@Service("joinService")
public class JoinServiceImpl extends BasicController implements JoinService {
	
	@Resource(name = "joinMapper")
	private JoinMapper joinMapper;
	
	/**
	 * ========================================
	 * 작성자   | 유재영 
	 * 설명     | 회원가입 후 로그인 페이지 이동
	 * ========================================
	 */
	@Override
	public void insertMber(JoinVO joinVO) throws Exception {
		String chgPw	= EgovFileScrty.encryptPassword(joinVO.getMberPw(), joinVO.getMberId());
		
		joinVO.setMberPw(chgPw);
		
		joinMapper.insertMber(joinVO);
	}

}
