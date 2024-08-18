package com.ssn.practica.model;

import java.util.Date;

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
	private String answer;

	@JoinColumn(nullable = false)
	private Date date;

	@ManyToOne
	@JoinColumn(name = "task_id", nullable = false)
	private Task task;
}
