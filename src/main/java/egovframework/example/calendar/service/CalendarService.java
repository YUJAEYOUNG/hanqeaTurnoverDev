package egovframework.example.calendar.service;

import java.util.List;
import java.util.Map;

public interface CalendarService {
	
	/**
	 * ========================================
	 * 작성자   | 유재영 
	 * 설명     | 일정관리 페이지 이동
	 * ========================================
	 */
	List<Map<String, Object>> selectCalendarList(Map<String, Object> loginMap) throws Exception;

}
