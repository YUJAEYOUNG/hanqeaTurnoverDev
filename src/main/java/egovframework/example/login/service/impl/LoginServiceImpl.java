package egovframework.example.login.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.cmmn.EgovFileScrty;
import egovframework.example.login.service.LoginService;
import egovframework.example.login.service.LoginVO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Resource(name = "loginMapper")
	private LoginMapper loginMapper;
	
	/**
	 * ========================================
	 * 작성자   | 유재영 
	 * 설명     | 로그인 처리
	 * ========================================
	 */
	@Override
	public LoginVO selectLoginUsr(String id, String password) throws Exception {
		String changePw	= EgovFileScrty.encryptPassword(password, id);
		
		Map<String, Object> hmap	= new HashMap<String, Object>();
		
		hmap.put("id", id);
		hmap.put("pw", changePw);
		
		LoginVO tempVO	= loginMapper.selectLoginUsr(hmap);
		
		if (tempVO != null && tempVO.getUserId() != null && tempVO.getUserNm() != null) {
			return tempVO;
		} else {
			LoginVO temp2VO	= new LoginVO(); 
			
			return temp2VO;
		}
	}

}
