package com.school.SchoolBoardAPI.responsedto;

import com.school.SchoolBoardAPI.entity.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
	
	private String username;
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private UserRole role;
	private long contactNumber;
}


