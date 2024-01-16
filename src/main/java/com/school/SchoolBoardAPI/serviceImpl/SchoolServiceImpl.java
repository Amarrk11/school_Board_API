package com.school.SchoolBoardAPI.serviceImpl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.school.SchoolBoardAPI.entity.School;
import com.school.SchoolBoardAPI.repository.SchoolRepository;
import com.school.SchoolBoardAPI.requestdto.SchoolRequestDTO;
import com.school.SchoolBoardAPI.responsedto.SchoolResponseDTO;
import com.school.SchoolBoardAPI.service.SchoolService;
import com.school.SchoolBoardAPI.utility.ResponseStructure;

public class SchoolServiceImpl implements SchoolService {
	SchoolRepository schoolrepository;
	public School schoolRequestDTOToschool(SchoolRequestDTO schoolRequestDTO)
	{
	School	school  = new School();
		school.setSchoolName(schoolRequestDTO.getSchoolName());
		school.setSchoolAddress(schoolRequestDTO.getSchoolAddress());
		school.setSchoolContactInfo(schoolRequestDTO.getSchoolContactInfo());
		school.setSchoolemailId(schoolRequestDTO.getSchoolemailId());
	;
		return school;
	}

	public SchoolResponseDTO schoolToSchoolResponseDTO(School school)
	{
		SchoolResponseDTO schoolResponseDTO= new SchoolResponseDTO();
		
		schoolResponseDTO.setSchoolId(school.getSchoolId());
		schoolResponseDTO.setSchoolName(school.getSchoolName());
		schoolResponseDTO.setSchoolContactInfo(school.getSchoolContactInfo());
		schoolResponseDTO.setSchoolemailId(school.getSchoolemailId());
		schoolResponseDTO.setSchoolAddress(school.getSchoolAddress());
		return schoolResponseDTO;
	}

	@Override
	public ResponseEntity<ResponseStructure<SchoolResponseDTO>> addschool(SchoolRequestDTO schoolRequestDTO, int schoolId) {
		School school =schoolRequestDTOToschool(schoolRequestDTO);
		School school1= schoolrepository.save(school);
		
		SchoolResponseDTO schoolResponse=schoolToSchoolResponseDTO(school1);
		ResponseStructure<SchoolResponseDTO> structure = new ResponseStructure<SchoolResponseDTO>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("School Data Inserted Successfully !");
		structure.setData(schoolResponse);
		return new ResponseEntity<ResponseStructure<SchoolResponseDTO>>(structure, HttpStatus.CREATED);
	}

	

	@Override
	public ResponseEntity<ResponseStructure<SchoolResponseDTO>> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> updateSchool(SchoolRequestDTO schoolRequestDTO, int schoolId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<SchoolResponseDTO>>> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<SchoolResponseDTO>> deleteById(int schoolId) {
		// TODO Auto-generated method stub
		return null;
	}

}
