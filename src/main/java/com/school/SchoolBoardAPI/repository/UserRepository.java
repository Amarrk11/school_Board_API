package com.school.SchoolBoardAPI.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.school.SchoolBoardAPI.entity.User;
import com.school.SchoolBoardAPI.entity.UserRole;

public interface UserRepository extends JpaRepository<User, Integer> {


	boolean existsByUserRole(UserRole userRole);


}
