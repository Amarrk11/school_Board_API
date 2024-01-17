package com.school.SchoolBoardAPI.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.SchoolBoardAPI.entity.Schedule;
import com.school.SchoolBoardAPI.exception.SchoolNotFoundByIdException;
import com.school.SchoolBoardAPI.exception.UnauthorizedAccessException;
import com.school.SchoolBoardAPI.repository.ScheduleRepository;
import com.school.SchoolBoardAPI.repository.SchoolRepository;
import com.school.SchoolBoardAPI.requestdto.ScheduleRequestDTO;
import com.school.SchoolBoardAPI.responsedto.ScheduleResponseDTO;
import com.school.SchoolBoardAPI.responsedto.SchoolResponseDTO;
import com.school.SchoolBoardAPI.service.ScheduleService;
import com.school.SchoolBoardAPI.utility.ResponseStructure;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;
	@Autowired
	private ResponseStructure<ScheduleResponseDTO> structure;
	@Autowired
	private SchoolRepository schoolRepository;

	private Schedule mapToSchedule(ScheduleRequestDTO scheduleRequest) {

		return Schedule.builder().opensAt(scheduleRequest.getOpensAt()).closesAt(scheduleRequest.getClosesAt())
				.classHoursPerDay(scheduleRequest.getClassHoursPerDay())
				.classHourLength(scheduleRequest.getClassHourLength()).breakTime(scheduleRequest.getBreakTime())
				.lunchTime(scheduleRequest.getLunchTime()).build();
	}

	private ScheduleResponseDTO mapToScheduleResponse(Schedule schedule) {
		return ScheduleResponseDTO.builder().schedulelId(schedule.getSchedulelId()).opensAt(schedule.getOpensAt())
				.classHourLength(schedule.getClassHourLength()).closesAt(schedule.getClosesAt())
				.classHoursPerDay(schedule.getClassHoursPerDay()).breakTime(schedule.getBreakTime())

				.lunchTime(schedule.getLunchTime())

				.build();
	}

	@Override
	public ResponseEntity<ResponseStructure<ScheduleResponseDTO>> addSchedlue(int schoolId,
			ScheduleRequestDTO scheduleRequest) {
		return schoolRepository.findById(schoolId).map(school -> {
			if (school.getSchedule() == null) {
				Schedule schedule = mapToSchedule(scheduleRequest);
				schedule = scheduleRepository.save(schedule);
				school.setSchedule(schedule);
				schoolRepository.save(school);
				structure.setMessage("scheduled for school");
				structure.setStatusCode(HttpStatus.CREATED.value());
	return new ResponseEntity<ResponseStructure<ScheduleResponseDTO>>(structure , HttpStatus.CREATED);
			} else
				throw new UnauthorizedAccessException("schedule already exist");
		}).orElseThrow(() -> new SchoolNotFoundByIdException("school with id not exist"));

	}

}
