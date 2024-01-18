package com.school.SchoolBoardAPI.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.school.SchoolBoardAPI.requestdto.AcademicProgramRequestDTO;
import com.school.SchoolBoardAPI.responsedto.AcademicProgramResponseDTO;
import com.school.SchoolBoardAPI.utility.ResponseStructure;

public interface AcademicProgramService  {
	public ResponseEntity<ResponseStructure<AcademicProgramResponseDTO>> createAcademicProgram(int schoolId,
			AcademicProgramRequestDTO academicProgramRequest);

	ResponseEntity<ResponseStructure<List<AcademicProgramResponseDTO>>> findAllAcademicPrograms(int schoolId);
}
