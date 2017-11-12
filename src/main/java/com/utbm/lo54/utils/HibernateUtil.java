package com.utbm.lo54.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/** 
* @author Dachen Li
* @date Nov 7, 2017 4:58:51 PM 
* Util class for buliding the hibernate session factory
*/

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
