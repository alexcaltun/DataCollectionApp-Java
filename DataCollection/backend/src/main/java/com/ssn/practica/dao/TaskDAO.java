package com.ssn.practica.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ssn.core.persistence.WithSessionAndTransaction;
import com.ssn.practica.model.Task;
import com.ssn.practica.model.TaskState;

public class TaskDAO {

	public List<Task> getTasks() {
		return new WithSessionAndTransaction<List<Task>>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				List<Task> tasks = session.createQuery("from Task").getResultList();
				setReturnValue(tasks);
			}
		}.run();
	}

	public void addTask(Task task) {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				session.save(task);
			}

		}.run();
	}

	public void deleteTask(String id) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Task task = session.get(Task.class, id);
				if (task != null) {
					session.delete(task);
				}
			}
		}.run();
	}

	public void updateTask(Task task) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				session.update(task);
			}
		}.run();
	}

	public List<Task> getTaskByTaskId(String taskId) {
		return new WithSessionAndTransaction<List<Task>>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				List<Task> tasks = session.createQuery("SELECT t FROM Task t WHERE t.taskId = :taskId", Task.class)
						.setParameter("taskId", taskId).getResultList();
				setReturnValue(tasks);
			}
		}.run();
	}

	public List<Task> getTasksByState(TaskState state) {
		return new WithSessionAndTransaction<List<Task>>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Query query = session.createQuery("from Task where state = :state");
				query.setParameter("state", state);
				List<Task> tasks = query.getResultList();
				setReturnValue(tasks);
			}
		}.run();
	}

	public List<Task> getTasksByDueDate(Date dueDate) {
		return new WithSessionAndTransaction<List<Task>>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Query query = session.createQuery("from Task where dueDate = :dueDate");
				query.setParameter("dueDate", dueDate);
				List<Task> tasks = query.getResultList();
				setReturnValue(tasks);
			}
		}.run();
	}
}
