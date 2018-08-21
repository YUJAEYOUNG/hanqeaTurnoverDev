package egovframework.example.main.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.example.cmmn.util.JsonUtil;
import egovframework.example.cmmn.web.BasicController;
import egovframework.example.main.service.MainService;

/**
 * ========================================
 * 작성자       | 유재영
 * 최초생성일   | 2018-08-03
 * 페이지       | MainController.java
 * 설명         | 메인 컨트롤러
 * ========================================
 */
@Controller
public class MainController extends BasicController {
	
	@Resource(name = "mainService")
	private MainService mainService;
	
	/**
	 * ========================================
	 * 작성자 | 유재영 
	 * 설명   | 메인 페이지 이동
	 * ========================================
	 */
	@RequestMapping(value = "/main.do")
	public String main(HttpServletRequest request, 
			ModelMap model) throws Exception {
		
		if (request.getSession().getAttribute("loginVO") == null) {
			return "redirect:/login.do";
		}
		
		return "main/main.tiles";
	}
	
	/**
	 * ========================================
	 * 작성자 | 유재영 
	 * 설명   | 메뉴 리스트 가져오기(최상위)
	 * ========================================
	 */
	@RequestMapping(value = "/mainMenuList.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String mainMenuList() throws Exception {
		List<Map<String, Object>> mainMenuList = mainService.selectMainMenuList();
		
		return JsonUtil.ListToJson(mainMenuList);
	}
	
	/**
	 * ========================================
	 * 작성자 | 유재영 
	 * 설명   | 서브메뉴 리스트 가져오기
	 * ========================================
	 */
	@RequestMapping(value = "/subMenuList.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String subMenuList(HttpServletRequest request) throws Exception {
		String menuId	= request.getParameter("menuId");
		
		List<Map<String, Object>> subMenuList = mainService.selectSubMenuList(menuId);
		
		return JsonUtil.ListToJson(subMenuList);
	}
}
