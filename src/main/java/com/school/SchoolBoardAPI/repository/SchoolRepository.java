package com.school.SchoolBoardAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.SchoolBoardAPI.entity.School;

public interface SchoolRepository  extends JpaRepository<School, Integer>{

}
