package com.utbm.lo54.controller;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utbm.lo54.entity.Client;
import com.utbm.lo54.entity.CourseSession;
import com.utbm.lo54.utils.HibernateUtil;

/** 
* @author Dachen Li
* @date Nov 12, 2017 7:15:07 PM 
* 
*/
@RestController
public class TestController {
	@RequestMapping(value = "/test")
	public void test(){
		Client client = new Client();
		client.setAddress("test");
		client.setEmail("test");
		client.setFirstName("test");
		client.setLastName("dddd");
		client.setPhone("15844220");
		CourseSession session = new CourseSession();
		session.setId(2);
		client.setSession(session);
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		session2.persist(client);
		session2.getTransaction().commit();
		session2.close();
	}

}
