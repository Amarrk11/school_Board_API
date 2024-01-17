package com.school.SchoolBoardAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.SchoolBoardAPI.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
