package com.school.SchoolBoardAPI.serviceImpl;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.school.SchoolBoardAPI.entity.Schedule;
import com.school.SchoolBoardAPI.exception.ScheduleNotFoundByIdException;
import com.school.SchoolBoardAPI.exception.SchoolNotFoundByIdException;
import com.school.SchoolBoardAPI.exception.UnauthorizedAccessException;
import com.school.SchoolBoardAPI.repository.ScheduleRepository;
import com.school.SchoolBoardAPI.repository.SchoolRepository;
import com.school.SchoolBoardAPI.requestdto.ScheduleRequestDTO;
import com.school.SchoolBoardAPI.responsedto.ScheduleResponseDTO;
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
		System.out.println(Duration.ofMinutes(scheduleRequest.getClassHourLengthInMinutes()) + ","
				+ Duration.ofMinutes(scheduleRequest.getLunchLengthInMinutes()));
		return Schedule.builder().opensAt(scheduleRequest.getOpensAt()).closesAt(scheduleRequest.getClosesAt())
				.classHoursPerDay(scheduleRequest.getClassHoursPerDay()).breakTime(scheduleRequest.getBreakTime())
				.lunchTime(scheduleRequest.getLunchTime())
				.classHourLengthInMinutes(Duration.ofMinutes(scheduleRequest.getClassHourLengthInMinutes()))
				.classHoursPerDay(scheduleRequest.getClassHoursPerDay())
				.breakLengthInMinutes(Duration.ofMinutes(scheduleRequest.getBreakLengthInMinutes())).build();
	}

	private ScheduleResponseDTO mapToScheduleResponse(Schedule schedule) {
		System.out.println(schedule.getBreakLengthInMinutes().toMinutes());
		return ScheduleResponseDTO.builder().schedulelId(schedule.getSchedulelId()).opensAt(schedule.getOpensAt())
				.closesAt(schedule.getClosesAt())
				.classHourLengthInMinutes((int) schedule.getClassHourLengthInMinutes().toMinutes())
				.breakLengthInMinutes((int) schedule.getBreakLengthInMinutes().toMinutes())
				.lunchLengthInMinutes((int) schedule.getLunchLengthInMinutes().toMinutes())
				.classHoursPerDay(schedule.getClassHoursPerDay()).breakTime(schedule.getBreakTime())
				.lunchTime(schedule.getLunchTime()).build();
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
				return new ResponseEntity<ResponseStructure<ScheduleResponseDTO>>(structure, HttpStatus.CREATED);
			} else
				throw new UnauthorizedAccessException("schedule already exist");
		}).orElseThrow(() -> new SchoolNotFoundByIdException("school with id not exist"));

	}

	@Override
	public ResponseEntity<ResponseStructure<ScheduleResponseDTO>> findScheduleByschool(int schoolId) {

		return schoolRepository.findById(schoolId).map(school -> {
			if (school.getSchedule() != null) {
				structure.setStatusCode(HttpStatus.FOUND.value());
				structure.setMessage("schedule data found");
				structure.setData(mapToScheduleResponse(school.getSchedule()));
				return new ResponseEntity<ResponseStructure<ScheduleResponseDTO>>(structure, HttpStatus.FOUND);
			} else
				throw new ScheduleNotFoundByIdException("Schedule data Not Found By Id");

		}).orElseThrow(() -> new SchoolNotFoundByIdException("School Data not Found to given Id"));

	}

	@Override
	public ResponseEntity<ResponseStructure<ScheduleResponseDTO>> updateById(int scheduleId,
			ScheduleRequestDTO scheduleRequest) {
		return scheduleRepository.findById(scheduleId).map(schedule -> {
			Schedule schedule2 = mapToSchedule(scheduleRequest);
			schedule2.setSchedulelId(schedule.getSchedulelId());
			schedule2 = scheduleRepository.save(schedule2);
			ScheduleResponseDTO scheduleResponse = mapToScheduleResponse(schedule2);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("schedule data Updated Successfully");
			structure.setData(scheduleResponse);
			return new ResponseEntity<ResponseStructure<ScheduleResponseDTO>>(structure, HttpStatus.OK);

		}).orElseThrow(() -> new ScheduleNotFoundByIdException("Schedule data Not Found By Id"));

	}

}
