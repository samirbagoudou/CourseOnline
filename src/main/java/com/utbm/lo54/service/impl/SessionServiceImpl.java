package com.utbm.lo54.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utbm.lo54.entity.CourseSession;
import com.utbm.lo54.repository.SessionRepository;
import com.utbm.lo54.service.SessionService;

/** 
* @author Dachen Li
* @date Nov 9, 2017 4:41:48 PM 
* The implementation class of interface SessionService 
* which is used for the service of the course sessions 
*/

@Service
public class SessionServiceImpl implements SessionService{

	@Autowired
	private SessionRepository sessionRepository;
	
	/**
	 * Get all the course sessions in the DB
	 * @param cityId 
	 * @param keyword 
	 * @param date 
	 */
	@Override
	public List<CourseSession> getSessions(String dateString, String keyword, Integer cityId) {
		Date date = null;
		//Parse the date from String to Date
		if(dateString != null){
			try {    
	    		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	            date = format.parse(dateString);
	    	} catch (ParseException e) {   
	    		//If the string of date is invalid, no data will be returned
	            e.printStackTrace();    
	            return null;
	        }   
		}	
		return sessionRepository.getSessions(date,keyword,cityId);
	}

}
