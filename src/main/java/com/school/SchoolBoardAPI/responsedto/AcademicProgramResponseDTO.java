package com.school.SchoolBoardAPI.responsedto;

import java.time.LocalDate;

import com.school.SchoolBoardAPI.entity.ProgramType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class AcademicProgramResponseDTO {
	private int programId;
	private ProgramType programtype;
	private String programName;
	private LocalDate beginAt;
	private LocalDate endsAt;
}
