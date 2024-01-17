package com.school.SchoolBoardAPI.responsedto;

import com.school.SchoolBoardAPI.entity.UserRole;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Getter
@Setter
public class UserResponseDTO {
	
	private String username;
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private UserRole role;
	private long contactNumber;
}


