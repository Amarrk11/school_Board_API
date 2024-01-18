package com.school.SchoolBoardAPI.entity;



import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class AcademicProgram {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int programId;
private ProgramType programtype;
private String programName;
private LocalDate beginAt;
private LocalDate endsAt;

@OneToMany
private List<School> school;
}
