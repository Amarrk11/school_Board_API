package com.school.SchoolBoardAPI.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.SchoolBoardAPI.entity.School;
import com.school.SchoolBoardAPI.entity.UserRole;

import com.school.SchoolBoardAPI.exception.UnauthorizedAccessException;
import com.school.SchoolBoardAPI.exception.UserNotFoundByIdException;
import com.school.SchoolBoardAPI.repository.SchoolRepository;
import com.school.SchoolBoardAPI.repository.UserRepository;
import com.school.SchoolBoardAPI.requestdto.SchoolRequestDTO;
import com.school.SchoolBoardAPI.responsedto.SchoolResponseDTO;
import com.school.SchoolBoardAPI.service.SchoolService;
import com.school.SchoolBoardAPI.utility.ResponseStructure;
@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	SchoolRepository schoolrepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	private ResponseStructure<SchoolResponseDTO> structure;
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
	@Override

	public ResponseEntity<ResponseStructure<SchoolResponseDTO>> addSchool(SchoolRequestDTO schoolRequest,int userId) {

		return userRepository.findById(userId).map(u ->{
			if(u.getUserRole().equals(UserRole.ADMIN)) {
				if(u.getSchool()==null) {
					School school= schoolRequestDTOToschool(schoolRequest);
					school = schoolrepository.save(school);
					u.setSchool(school);
					userRepository.save(u);
					structure.setData(schoolToSchoolResponseDTO(school));
					structure.setMessage("school saved successfully");
					structure.setStatusCode(HttpStatus.CREATED.value());
					return new ResponseEntity<ResponseStructure<SchoolResponseDTO>>(structure , HttpStatus.CREATED);
				}
				else throw new UnauthorizedAccessException("school already exist");	
			}
			else  throw new UnauthorizedAccessException("only admin Create School");
			
		}
				).orElseThrow(()->new UserNotFoundByIdException("user not exist"));
		
		}
	






}

