package com.school.SchoolBoardAPI.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.SchoolBoardAPI.entity.User;
import com.school.SchoolBoardAPI.entity.UserRole;
import com.school.SchoolBoardAPI.exception.UserNotFoundByIdException;
import com.school.SchoolBoardAPI.repository.UserRepository;
import com.school.SchoolBoardAPI.requestdto.UserRequestDTO;
import com.school.SchoolBoardAPI.responsedto.UserResponseDTO;
import com.school.SchoolBoardAPI.service.UserService;
import com.school.SchoolBoardAPI.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userrepo;
	@Autowired
	private ResponseStructure<UserResponseDTO> structure;
	
	private User mapToUser(UserRequestDTO request) {
		return  User.builder().username(request.getUsername())
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.contactNumber(request.getContactNumber())
				.email(request.getEmail())
				.password(request.getPassword())
				.userRole(request.getRole()).build();
				
	}
	private UserResponseDTO mapToUserResponse(User user) {
		return UserResponseDTO.builder().userId(user.getUserlId())
				.username(user.getUsername())
				.firstName(user.getFirstName())
				.userId(user.getUserlId())
				.lastName(user.getLastName())
				.role(user.getUserRole())
				.email(user.getEmail())
				.build();
	}
	
	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> addUser(UserRequestDTO userRequest) {
		
		if(userRequest.getRole()==UserRole.ADMIN && userrepo.existsByUserRole(UserRole.ADMIN))
		{
			structure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			structure.setMessage("Admin not Authorised");
			
			return new ResponseEntity<ResponseStructure<UserResponseDTO>>(structure,HttpStatus.BAD_REQUEST);
		}
		User user = mapToUser(userRequest);

	     user = userrepo.save(user); 

		 
	     UserResponseDTO userResponse = mapToUserResponse(user);
	     
	     structure.setStatusCode(HttpStatus.CREATED.value());
	     structure.setMessage("User Created");
	     structure.setData(userResponse);
	     
		return new ResponseEntity<ResponseStructure<UserResponseDTO>>(structure,HttpStatus.CREATED);
		        
	}


	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> findUserById(int userId) {

		User user = userrepo.findById(userId).orElseThrow(()->new UserNotFoundByIdException("User Not present for given id"));

		UserResponseDTO userResponse = mapToUserResponse(user);

		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage("User Found");
		structure.setData(userResponse);

		return new ResponseEntity<ResponseStructure<UserResponseDTO>>(structure,HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> deleteUserById(int userId) {
		User user = userrepo.findById(userId).orElseThrow(()->new UserNotFoundByIdException("User Not present for given id"));
		
		if(user.isDeleted()==false)
			user.setDeleted(true);
		
		User user2 = userrepo.save(user);
		
		
		UserResponseDTO userResponse = mapToUserResponse(user2);
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("deletion status updated successfully");
		structure.setData(userResponse);
		return new ResponseEntity<ResponseStructure<UserResponseDTO>>(structure,HttpStatus.OK);
	}

}
