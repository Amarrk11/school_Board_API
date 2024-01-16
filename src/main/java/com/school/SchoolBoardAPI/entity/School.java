package com.school.SchoolBoardAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity

@Getter
@Setter
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schoolId;
	@OneToOne
	private Schedule schedule;
	private long schoolContactInfo;
	private String schoolName;
	private String schoolemailId;
	private String schoolAddress;
}
