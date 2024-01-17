package com.school.SchoolBoardAPI.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.school.SchoolBoardAPI.requestdto.UserRequestDTO;
import com.school.SchoolBoardAPI.responsedto.UserResponseDTO;
import com.school.SchoolBoardAPI.service.UserService;
import com.school.SchoolBoardAPI.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController

public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/users/register")
	public ResponseEntity<ResponseStructure<UserResponseDTO>> addUser(@RequestBody @Valid UserRequestDTO request) {
		return userService.addUser(request);
	}
	@GetMapping("/users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponseDTO>> findById(@PathVariable int userId){
		return userService.findUserById(userId);
	}

	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		userService.deleteUserById(userId);
	}
}
