package com.lovo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DaoBasic {

    private static StandardServiceRegistry registry;

    static {
        registry = new StandardServiceRegistryBuilder().configure("hibernate.xml").build();
    }

    public static SessionFactory getSessionFactory() {
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
}
