// backend/src/main/java/com/example/dao/UserDAO.java
package com.ssn.practica.dao;

import java.util.List;

import org.hibernate.Session;

import com.ssn.core.persistence.WithSessionAndTransaction;
import com.ssn.practica.model.User;

public class UserDAO {

	public List<User> getUsers() {
		return new WithSessionAndTransaction<List<User>>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				List<User> users = session.createQuery("from User").getResultList();
				setReturnValue(users);
			}
		}.run();
	}

	public void addUser(User user) {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				session.save(user);
			}

		}.run();
	}

	public void deleteUser(long userId) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				User user = session.get(User.class, userId);
				if (user != null) {
					session.delete(user);
				}
			}
		}.run();
	}

	public void updateUser(User user) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				session.update(user);
			}
		}.run();
	}

	public User getUserById(long id) {
		return new WithSessionAndTransaction<User>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				User user = session.get(User.class, id);
				setReturnValue(user);
			}
		}.run();
	}

}
