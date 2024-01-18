package com.school.SchoolBoardAPI.requestdto;

import java.time.LocalDate;

import com.school.SchoolBoardAPI.entity.ProgramType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class AcademicProgramRequestDTO {
	private ProgramType programtype;
	private String programName;
	private LocalDate beginAt;
	private LocalDate endsAt;
}
