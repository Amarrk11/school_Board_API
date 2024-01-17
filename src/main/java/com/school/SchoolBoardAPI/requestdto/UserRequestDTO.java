package com.school.SchoolBoardAPI.requestdto;

import com.school.SchoolBoardAPI.entity.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRequestDTO {

	@NotEmpty(message = "Username is required")
  @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
  @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username can only contain letters and numbers")
	
	private String username;
	@NotEmpty(message="phone number required")
	@Pattern(regexp = "^[1-9][0-9]{9}$")
	private long contactNumber;

	@NotEmpty(message = "Password is required")
	@Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
	@Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=])(?=\\S+$).{8,}$",
	message = "Password should" + " contain at least one letter, one number, one special character")
	private String password;
	@NotEmpty(message = "first Name Can't be empty")
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$" , message = "Firstname should follow initcap")
	private String firstName;
	@NotEmpty(message = "last Name Can't be empty")
	@Pattern(regexp = "^[A-Z][a-zA-Z]*$" , message = "Lastname should follow initcap")
	private String lastName;
	@NotEmpty(message = "Invalid email")
	@Email(regexp = "[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}", message = "invalid email ")
	private String email;
	private UserRole role;
}

