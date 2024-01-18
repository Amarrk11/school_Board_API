package com.school.SchoolBoardAPI.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.school.SchoolBoardAPI.entity.AcademicProgram;

import com.school.SchoolBoardAPI.exception.SchoolNotFoundByIdException;
import com.school.SchoolBoardAPI.exception.UnauthorizedAccessException;
import com.school.SchoolBoardAPI.repository.AcademicProgramRepository;
import com.school.SchoolBoardAPI.repository.SchoolRepository;
import com.school.SchoolBoardAPI.requestdto.AcademicProgramRequestDTO;
import com.school.SchoolBoardAPI.responsedto.AcademicProgramResponseDTO;
import com.school.SchoolBoardAPI.service.AcademicProgramService;
import com.school.SchoolBoardAPI.utility.ResponseStructure;

public class AcadamicProgramServiceImpl implements AcademicProgramService {
	@Autowired
	private AcademicProgramRepository academicProgramRepository;
	@Autowired
	private SchoolRepository schoolRepository;
	@Autowired
	private ResponseStructure<AcademicProgramResponseDTO> structure;

	private AcademicProgram mapToAcademicProgram(AcademicProgramRequestDTO request) {
		return AcademicProgram.builder().programName(request.getProgramName()).programtype(request.getProgramtype())
				.beginAt(request.getBeginAt()).endsAt(request.getEndsAt()).build();
	}

	private AcademicProgramResponseDTO mapToAcademicResponse(AcademicProgram academicProgram) {
		return AcademicProgramResponseDTO.builder().beginAt(academicProgram.getBeginAt())
				.programId(academicProgram.getProgramId()).endsAt(academicProgram.getEndsAt())
				.programName(academicProgram.getProgramName()).programtype(academicProgram.getProgramtype()).build();
	}

	@Override
	public ResponseEntity<ResponseStructure<AcademicProgramResponseDTO>> createAcademicProgram(int schoolId,
			AcademicProgramRequestDTO academicProgramRequest) {
		return schoolRepository.findById(schoolId).map(school -> {
			AcademicProgram academicProgram =mapToAcademicProgram(academicProgramRequest);
			academicProgram = academicProgramRepository.save(academicProgram);
			school.getAcademicPrograms().add(academicProgram);
			schoolRepository.save(school);
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("academic program created for the school");
			structure.setData(mapToAcademicResponse(academicProgram))
			;
			return new ResponseEntity<ResponseStructure<AcademicProgramResponseDTO>>(structure, HttpStatus.FOUND);
		}).orElseThrow(() -> new SchoolNotFoundByIdException("School Data not Found to given Id"));
	}
	@Override
	public ResponseEntity<ResponseStructure<List<AcademicProgramResponseDTO>>> findAllAcademicPrograms(int schoolId) {
		return schoolRepository.findById(schoolId).map(school->{

			List<AcademicProgram> programs = academicProgramRepository.findAll();

			if(!programs.isEmpty())
			{
				List<AcademicProgramResponseDTO> list=new ArrayList<>();

				for(AcademicProgram program : programs)
				{
					AcademicProgramResponseDTO programResponse = mapToAcademicResponse(program);
					list.add(programResponse);
				}
				ResponseStructure<List<AcademicProgramResponseDTO>> structure=new ResponseStructure<>();
				structure.setStatusCode(HttpStatus.FOUND.value());
				structure.setMessage("Academic Program List found");
				structure.setData(list);


				return new ResponseEntity<ResponseStructure<List<AcademicProgramResponseDTO>>>(structure,HttpStatus.FOUND);

			}
			else
				throw new UnauthorizedAccessException("No Academic Programs present for given school");

		}).orElseThrow(()->new SchoolNotFoundByIdException("School Not Present for given school id"));
	}
}
