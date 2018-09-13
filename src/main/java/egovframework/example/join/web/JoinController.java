package egovframework.example.join.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.example.cmmn.EgovMessageSource;
import egovframework.example.cmmn.validator.JoinVOValidator;
import egovframework.example.join.service.JoinService;
import egovframework.example.join.service.JoinVO;

/**
 * ========================================
 * 작성자       | 유재영
 * 최초생성일   | 2018-08-03
 * 페이지       | JoinController.java
 * 설명         | 회원가입
 * ========================================
 */
@Controller
public class JoinController {
	
	@Resource(name = "joinService")
	private JoinService joinService;
	
	@Resource(name = "joinVOValidator")
	private JoinVOValidator joinVOValidator;
	
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(this.joinVOValidator);
	}
	
	/**
	 * ========================================
	 * 작성자   | 유재영 
	 * 설명     | 회원가입 밸리데이션 체크
	 * ========================================
	 */
	@RequestMapping(value = "/joinFrmChk.do")
	public String joinInfo(@Validated JoinVO joinVO,
			BindingResult bindingResult, 
			ModelMap model) throws Exception {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("eSangMu", "N");
		} else {
			model.addAttribute("eSangMu", "Y");
		}
		
		return "login/login";
	}
	
	/**
	 * ========================================
	 * 작성자   | 유재영 
	 * 설명     | 회원가입 후 로그인 페이지 이동
	 * ========================================
	 */
	@RequestMapping(value = "/insertUsrInfo.do", method = RequestMethod.POST)
	public String insertUsrInfo(@ModelAttribute JoinVO joinVO) throws Exception {
		
		joinService.insertMber(joinVO);
		
		return "forward:/login.do";
	}
}
