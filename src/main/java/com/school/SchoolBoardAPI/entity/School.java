package com.school.SchoolBoardAPI.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	@OneToMany(mappedBy = "school")
	private List<AcademicProgram> academicPrograms;
}
