package egovframework.example.calendar.web;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.calendar.service.CalendarService;
import egovframework.example.cmmn.util.SessionUtil;
import egovframework.example.cmmn.web.BasicController;

/**
 * ========================================
 * 작성자       | 유재영
 * 최초생성일   | 2018-08-27
 * 페이지       | CalanderController.java
 * 설명         | 일정관리 컨트롤러
 * ========================================
 */
@Controller
public class CalendarController extends BasicController {
	
	@Resource(name = "calendarService")
	private CalendarService calendarService;
	
	/**
	 * ========================================
	 * 작성자   | 유재영 
	 * 설명     | 일정관리 페이지 이동
	 * ========================================
	 */
	@RequestMapping(value = "/calendar.do")
	public String Calander(HttpServletRequest request,
			ModelMap model) throws Exception {
		Calendar cal	= Calendar.getInstance();
		int year 		= cal.get(Calendar.YEAR);
        int month 		= cal.get(Calendar.MONTH) + 1;
        String mon		= month < 10 ? "0" + month : String.valueOf(month);
        String date		= String.valueOf(year) + mon;
        System.out.println("date ::: " + date);
        
		Map<String, Object> loginMap	= SessionUtil.getLoginVODataToMap();
		loginMap.put("date",  	date);
		
		System.out.println("loginMap ::: " + loginMap.toString());
		List<Map<String, Object>> calendarList	= calendarService.selectCalendarList(loginMap);
		
		System.out.println("calendarList ::: " + calendarList);
		model.addAttribute("calendarList", calendarList);
		
 		return "calendar/calendar.tiles";
	}
}
