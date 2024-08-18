package com.ssn.practica.dto;

import java.util.Date;

import com.ssn.practica.model.Answer;

public class AnswerDTO {

	private Long id;
	private String answer;
	private Date date;

	public AnswerDTO() {
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

	public static AnswerDTO fromAnswer(Answer answer) {
		AnswerDTO answerDTO = new AnswerDTO();

		answerDTO.setAnswer(answer.getAnswer());
		answerDTO.setId(answer.getId());
		answerDTO.setDate(answer.getDate());

		return answerDTO;
	}

}
