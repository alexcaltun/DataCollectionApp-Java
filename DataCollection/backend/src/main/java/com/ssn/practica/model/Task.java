package com.ssn.practica.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@JoinColumn(nullable = false)
	private Long taskId;

	@JoinColumn(nullable = false)
	private String country;

	@JoinColumn(nullable = false)
	private String city;

	@JoinColumn(nullable = true)
	private String zone;

	@JoinColumn(nullable = false)
	private String description;

	@JoinColumn(nullable = false)
	private Date dueDate;

	@OneToMany(mappedBy = "task")
	private List<Answer> answers;

	public Task() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskId=" + taskId + ", country=" + country + ", city=" + city + ", zone=" + zone
				+ ", description=" + description + ", dueDate=" + dueDate + ", answers=" + answers + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(taskId);
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
		Task other = (Task) obj;
		return Objects.equals(taskId, other.taskId);
	}

}
