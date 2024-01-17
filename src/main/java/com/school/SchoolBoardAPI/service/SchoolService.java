package com.school.SchoolBoardAPI.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.school.SchoolBoardAPI.entity.UserRole;
import com.school.SchoolBoardAPI.requestdto.SchoolRequestDTO;
import com.school.SchoolBoardAPI.responsedto.SchoolResponseDTO;

import com.school.SchoolBoardAPI.utility.ResponseStructure;

public interface SchoolService {
	public ResponseEntity<ResponseStructure<SchoolResponseDTO>> addSchool(SchoolRequestDTO schoolRequest,int userId);
//	public ResponseEntity<ResponseStructure<SchoolResponseDTO>> addschool(SchoolRequestDTO schoolRequestDTO, int schoolId);
	public ResponseEntity<ResponseStructure<SchoolResponseDTO>>findById(int id);
	public ResponseEntity<ResponseStructure<String>> updateSchool(SchoolRequestDTO schoolRequestDTO,int schoolId);
	public ResponseEntity<ResponseStructure<List<SchoolResponseDTO>>> findall();
	public ResponseEntity<ResponseStructure<SchoolResponseDTO>>deleteById(int schoolId);

}
