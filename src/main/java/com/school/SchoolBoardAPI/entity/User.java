package com.school.SchoolBoardAPI.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userlId;
	@Column(unique = true) //it will not allow the repetitive usernames
private String username;
private String password;
private String firstName;
private String lastName;
@Column(unique = true)
private String email;
private long contactNumber;
private UserRole userRole;
private boolean isDeleted;
@ManyToOne
private School school;
}
