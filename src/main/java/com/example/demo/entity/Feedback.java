package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="feedback_list")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Name", nullable = false)
	private String name;
	
	@Column(name="Message", nullable = false)
	private String message;
	
	@Column(name="Type", nullable = false)
	private String type;
	
	@Column(name="Email", nullable = false)
	private String email;
	
	@Column(name="Status", nullable = false)
	private String status = "PENDING";
	
	@Column(name="Date", nullable = false)
	private LocalDate submissionDate;
	
	@PrePersist
	protected void onCreate() {
		submissionDate = LocalDate.now();
	}

	//////////////////////////////////////
	public Feedback() {}
	
	public Feedback(Long id, String name, String message, String type, String email, String status,
			LocalDate submissionDate) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.type = type;
		this.email = email;
		this.status = status;
		this.submissionDate = submissionDate;
	}

	//////////////////////////////////////////////////////
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}


	

}
