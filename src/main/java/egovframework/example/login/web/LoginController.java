package egovframework.example.login.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.cmmn.web.BasicController;
import egovframework.example.join.service.JoinVO;
import egovframework.example.login.service.LoginService;
import egovframework.example.login.service.LoginVO;

/**
 * ========================================
 * 작성자       | 유재영
 * 최초생성일   | 2018-08-03
 * 페이지       | LoginController.java
 * 설명         | TODO !!
 * ========================================
 */
@Controller
public class LoginController extends BasicController {
	
	@Resource(name = "loginService")
	private LoginService loginService;
	
	/**
	 * ========================================
	 * 작성자   | 유재영 
	 * 설명     | 로그인 페이지 이동
	 * ========================================
	 */
	@RequestMapping(value = "/login.do")
	public String login(HttpServletRequest request,
			@ModelAttribute JoinVO joinVO) throws Exception {
		return "login/login";
	}
	
	/**
	 * ========================================
	 * 작성자   | 유재영 
	 * 설명     | 로그인 처리
	 * ========================================
	 */
	@RequestMapping(value = "/actionLogin.do")
	public String actionLogin(HttpServletRequest request,
			ModelMap model,
			@ModelAttribute JoinVO joinVO) throws Exception {
		String id		= request.getParameter("userId");
		String password	= request.getParameter("userPw");
		
		LoginVO resVO	= loginService.selectLoginUsr(id, password);
		
		System.out.println("resVO ::: " + resVO.toString());
		
		if (resVO.getUserId() != null && !resVO.getUserId().equals("")) {
			request.getSession().setAttribute("loginVO", resVO);
			
			return "redirect:/main.do";
		} else {
			model.addAttribute("success", "N");
			return "login/login";
		}
	}
}
