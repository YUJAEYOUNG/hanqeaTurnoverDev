package egovframework.example.calendar.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.calendar.service.CalendarService;

@Service("calendarService")
public class CalendarServiceImpl implements CalendarService {
	
	@Resource(name = "calendarMapper")
	private CalendarMapper calendarMapper;
	
	/**
	 * ========================================
	 * 작성자   | 유재영 
	 * 설명     | 일정관리 페이지 이동
	 * ========================================
	 */
	@Override
	public List<Map<String, Object>> selectCalendarList(Map<String, Object> loginMap) throws Exception {
		return calendarMapper.selectCalendarList(loginMap);
	}

}
