package com.ssn.practica.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@JoinColumn(nullable = false)
	private String answerId;

	@JoinColumn(nullable = false)
	private String answer;

	@JoinColumn(nullable = false)
	private Date date;

	@ManyToOne
	@JoinColumn(name = "task_id", nullable = false)
	private Task task;

	public Answer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answerId=" + answerId + ", answer=" + answer + ", date=" + date + "taskId= "
				+ task.getTaskId() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(answerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Answer other = (Answer) obj;
		return Objects.equals(answerId, other.answerId);
	}

}
