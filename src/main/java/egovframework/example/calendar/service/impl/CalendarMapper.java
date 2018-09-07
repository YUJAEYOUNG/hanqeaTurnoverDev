package egovframework.example.calendar.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("calendarMapper")
public interface CalendarMapper {

	List<Map<String, Object>> selectCalendarList(Map<String, Object> loginMap) throws Exception;

}
