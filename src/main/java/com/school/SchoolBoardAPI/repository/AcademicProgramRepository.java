package com.school.SchoolBoardAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.SchoolBoardAPI.entity.AcademicProgram;

public interface AcademicProgramRepository extends JpaRepository<AcademicProgram, Integer> {

}
