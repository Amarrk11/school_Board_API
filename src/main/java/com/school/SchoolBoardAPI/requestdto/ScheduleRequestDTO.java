package com.school.SchoolBoardAPI.requestdto;

import java.time.LocalTime;

import com.school.SchoolBoardAPI.entity.School;


import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
@Data
public class ScheduleRequestDTO {
	
	@OneToOne
	private School school;
	private LocalTime opensAt;
	private LocalTime closesAt;
	private LocalTime breakTime;
	private LocalTime lunchTime;
	private int classHoursPerDay;
	private LocalTime classHourLength;
}
