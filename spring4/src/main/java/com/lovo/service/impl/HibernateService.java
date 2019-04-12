package com.lovo.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

@Service("hibernateService")
public class HibernateService {


//    @Autowired
    LocalSessionFactoryBean localSessionFactoryBean;

    public Session getSession() {


        SessionFactory sessionFactory = localSessionFactoryBean.getObject();

        Session session = sessionFactory.openSession();

        return session;

    }

    public Session getCurrentSession() {


        SessionFactory sessionFactory = localSessionFactoryBean.getObject();

        Session session = sessionFactory.getCurrentSession();

        return session;

    }
}
