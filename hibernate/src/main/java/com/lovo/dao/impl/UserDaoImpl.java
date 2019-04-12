package com.lovo.dao.impl;

import com.lovo.dao.DaoBasic;
import com.lovo.dao.UserDao;
import com.lovo.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static SessionFactory sessionFactory = null;

    static {
        sessionFactory = DaoBasic.getSessionFactory();
    }

    @Override
    public int add(UserEntity userEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();


        try {
            Serializable save = session.save(userEntity);
            System.out.println(save);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int del(int id) {
        return 0;
    }

    @Override
    public int update(UserEntity userEntity) {
        return 0;
    }

    @Override
    public UserEntity get(int id) {
        return null;
    }

    @Override
    public List<UserEntity> getList() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        List list = null;

        try {
            Query query = session.createQuery("from UserEntity");
            list = query.list();

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return list;
    }

    @Override
    public int size() {
        return 0;
    }
}
