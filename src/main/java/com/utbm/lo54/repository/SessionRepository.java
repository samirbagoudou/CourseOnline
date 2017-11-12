package com.utbm.lo54.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.utbm.lo54.entity.Course;
import com.utbm.lo54.entity.CourseSession;
import com.utbm.lo54.utils.HibernateUtil;

/**
 * @author Dachen Li
 * @date Nov 9, 2017 6:26:16 PM
 * 
 */
@Repository
public class SessionRepository {

	public List<CourseSession> getSessions(Date date, String keyword, Integer cityId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<CourseSession> result = null;
		try {
			tx = session.beginTransaction();
			
			//Create the criteria for the class CourseSession
			Criteria criteria = session.createCriteria(CourseSession.class);

			// If the date is indicated, add the criteria "startDate <= date && date <= endDate"
			if (date != null) {
				criteria.add(Restrictions.le("startDate", date)).add(Restrictions.ge("endDate", date));
			}

			// If the keyword is indicated, add the criteria "course.title contains keyword"
			if (keyword != null) {
				criteria.createAlias("course", "co").add(Restrictions.like("co.title", "%" + keyword + "%"));
			}
			// If the cityId is indicated, add the criteria "location.id = cityId"
			if (cityId != null) {
				criteria.createAlias("location", "lo").add(Restrictions.eq("lo.id", cityId));
			}
			// Get the result list of course session with the criteria defined
			result = criteria.list();
			session.getTransaction().commit();
		} catch (HibernateException he) {
			if (tx != null)
				tx.rollback();
				he.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

}
