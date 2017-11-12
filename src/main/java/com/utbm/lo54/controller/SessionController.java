package com.utbm.lo54.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utbm.lo54.entity.Course;
import com.utbm.lo54.entity.CourseSession;
import com.utbm.lo54.service.SessionService;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * @author Dachen Li 
 * @date Nov 9, 2017 4:38:38 PM
 * 
 */

@RestController
public class SessionController {

	@Autowired
	private SessionService sessionService;

	/**
	 * Get all the course sessions in the DB with the following criteria(optional)
	 * @param cityId 
	 * @param keyword 
	 * @param date 
	 */
	@GetMapping(value = "/sessions")
	public List<CourseSession> getSessions(@RequestParam(value = "date", required = false) String date,
																  @RequestParam(value = "keyword", required = false) String keyword,
																  @RequestParam(value = "cityId", required = false) Integer cityId) {
		List<CourseSession> list =sessionService.getSessions(date, keyword, cityId);
		return list;
	}
	
}
