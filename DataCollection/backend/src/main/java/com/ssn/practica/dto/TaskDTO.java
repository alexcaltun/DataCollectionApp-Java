package com.ssn.practica.dto;

import java.util.Date;
import java.util.List;

import com.ssn.practica.model.Answer;
import com.ssn.practica.model.Task;

public class TaskDTO {
	private Long id;
	private Long taskId;
	private String country;
	private String city;
	private String zone;
	private String description;
	private Date dueDate;
	private List<AnswerDTO> answersDTO;

	public TaskDTO() {
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

	public List<AnswerDTO> getAnswersDTO() {
		return answersDTO;
	}

	public void setAnswersDTO(List<AnswerDTO> answersDTO) {
		this.answersDTO = answersDTO;
	}

	public static TaskDTO fromTask(Task task) {
		TaskDTO taskDTO = new TaskDTO();

		taskDTO.setId(task.getId());
		taskDTO.setCountry(task.getCountry());
		taskDTO.setCity(task.getCity());
		taskDTO.setZone(task.getZone());
		taskDTO.setDescription(task.getDescription());
		taskDTO.setDueDate(task.getDueDate());

		for (Answer answer : task.getAnswers()) {
			taskDTO.getAnswersDTO().add(AnswerDTO.fromAnswer(answer));
		}

		return taskDTO;
	}
}
