/*
 * Copyright (c) 2014 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.ssn.core.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ssn.practica.model.Order;
import com.ssn.practica.model.OrderState;
import com.ssn.practica.model.User;

/**
 * @author <a href="mailto:rveina@ssi-schaefer-noell.com">rveina</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public class SessionFactoryProvider {

	public static void main(String[] args) {
		SessionFactoryProvider.init();
	}

	private static SessionFactory factory;

	public static SessionFactory getSessionFactory() {
		if (factory == null) {
			try {
//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//        factory = configuration.buildSessionFactory(builder.build());

				factory = new Configuration().configure("hibernate.cfg.xml") //
						.addAnnotatedClass(User.class) //
						.addAnnotatedClass(Order.class) //
						.buildSessionFactory();
				init();
			} catch (Throwable ex) {
				System.err.println("Failed to create sessionFactory object." + ex);
			}
		}

		return factory;
	}

	private static void init() {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				User user = new User();
				user.setName("asdasd");
				user.setEmail("zxczxcx");
				session.save(user);

				Order order = new Order();

				order.setOrderId("123");
				order.setState(OrderState.NEW);

				session.save(order);
			}

		}.run();
	}
}
