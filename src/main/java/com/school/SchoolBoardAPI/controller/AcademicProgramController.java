package com.school.SchoolBoardAPI.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.SchoolBoardAPI.requestdto.AcademicProgramRequestDTO;
import com.school.SchoolBoardAPI.responsedto.AcademicProgramResponseDTO;
import com.school.SchoolBoardAPI.service.AcademicProgramService;
import com.school.SchoolBoardAPI.utility.ResponseStructure;

@RestController
public class AcademicProgramController {

	private AcademicProgramService academicProgramService;

	@PostMapping("/schools/{schoolId}/academic-programs")
	public ResponseEntity<ResponseStructure<AcademicProgramResponseDTO>> createAcademicProgram(
			@PathVariable int schoolId, @RequestBody AcademicProgramRequestDTO academicProgramRequest) {
		return academicProgramService.createAcademicProgram(schoolId, academicProgramRequest);
	}
	@GetMapping("/schools/{schoolId}/academic-programs")
	public ResponseEntity<ResponseStructure<List<AcademicProgramResponseDTO>>> findAllAcademicPrograms(@PathVariable  int schoolId) {
return academicProgramService.findAllAcademicPrograms(schoolId);
}
}