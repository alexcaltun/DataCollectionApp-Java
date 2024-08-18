// backend/src/main/java/com/example/dao/UserDAO.java
package com.ssn.practica.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ssn.core.persistence.WithSessionAndTransaction;
import com.ssn.practica.model.Order;
import com.ssn.practica.model.OrderState;

public class OrderDAO {

	public List<Order> getOrdersByState(OrderState state) {
		return new WithSessionAndTransaction<List<Order>>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				Query query = session.createQuery("from Order where state = :state");
				query.setParameter("state", state);
				List<Order> orders = query.getResultList();
				setReturnValue(orders);
			}
		}.run();
	}

	public List<Order> getOrders() {
		return new WithSessionAndTransaction<List<Order>>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				Query query = session.createQuery("from Order");
				List<Order> users = query.getResultList();
				setReturnValue(users);
			}
		}.run();
	}

	public void finishOrder(long id) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Order order = session.get(Order.class, id);
				if (order != null) {
					order.setState(OrderState.FINISHED);
					session.update(order);
				}
			}
		}.run();
	}

	public Order getOrderByOrderId(String orderId) {
		return new WithSessionAndTransaction<Order>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Query<Order> query = session.createQuery("from Order o where o.orderId = :orderId");
				query.setParameter("orderId", orderId);
				Order order = query.uniqueResult();
				setReturnValue(order);
			}
		}.run();
	}

	public void cancelOrder(long id) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Order order = session.get(Order.class, id);
				if (order != null) {
					order.setState(OrderState.NEW);
					session.update(order);
				}
			}
		}.run();
	}
}
