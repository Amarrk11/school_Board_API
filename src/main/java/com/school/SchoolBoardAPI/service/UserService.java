package com.school.SchoolBoardAPI.service;

import org.springframework.http.ResponseEntity;

import com.school.SchoolBoardAPI.requestdto.UserRequestDTO;
import com.school.SchoolBoardAPI.responsedto.UserResponseDTO;
import com.school.SchoolBoardAPI.utility.ResponseStructure;

public interface UserService {
	
ResponseEntity<ResponseStructure<UserResponseDTO>> addUser(UserRequestDTO userRequest);
public ResponseEntity<ResponseStructure<UserResponseDTO>> findUserById(int userId);
public ResponseEntity<ResponseStructure<UserResponseDTO>> deleteUserById(int userId);
}
