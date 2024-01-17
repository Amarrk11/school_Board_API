package com.school.SchoolBoardAPI.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.SchoolBoardAPI.requestdto.SchoolRequestDTO;
import com.school.SchoolBoardAPI.responsedto.SchoolResponseDTO;
import com.school.SchoolBoardAPI.service.SchoolService;
import com.school.SchoolBoardAPI.utility.ResponseStructure;

@RestController
public class SchoolController {
	
@Autowired
private SchoolService schoolService ;

@PostMapping("/users/{userId}/schools")
public ResponseEntity<ResponseStructure<SchoolResponseDTO>> 
addSchool( @PathVariable int userId, @RequestBody  SchoolRequestDTO schoolRequest) {
	return schoolService.addSchool(schoolRequest, userId);
}

}
