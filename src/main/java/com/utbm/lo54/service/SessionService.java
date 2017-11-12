package com.utbm.lo54.service;

import java.util.List;

import com.utbm.lo54.entity.CourseSession;

/**
 * @author Dachen Li
 * @date Nov 9, 2017 4:42:35 PM 
 * The interface for the service of the course sessions
 */

public interface SessionService {

	/**
	 * Get all the course sessions in the DB
	 * @param cityId 
	 * @param keyword 
	 * @param date 
	 */
	public List<CourseSession> getSessions(String date, String keyword, Integer cityId);


}
