package com.school.SchoolBoardAPI.entity;

import java.time.Duration;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Builder
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schedulelId;
	@OneToOne
	private School school;
	private LocalTime opensAt;
	private LocalTime closesAt;
	private LocalTime breakTime;
	private LocalTime lunchTime;
	private int classHoursPerDay;
	private Duration classHourLengthInMinutes;
	private Duration breakLengthInMinutes;
	private Duration lunchLengthInMinutes;
	
	

}
