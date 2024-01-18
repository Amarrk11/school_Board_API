package com.school.SchoolBoardAPI.service;

import org.springframework.http.ResponseEntity;

import com.school.SchoolBoardAPI.requestdto.ScheduleRequestDTO;
import com.school.SchoolBoardAPI.responsedto.ScheduleResponseDTO;
import com.school.SchoolBoardAPI.utility.ResponseStructure;

public interface ScheduleService {

	ResponseEntity<ResponseStructure<ScheduleResponseDTO>> addSchedlue(int schoolId,
			ScheduleRequestDTO scheduleRequest);
	public ResponseEntity<ResponseStructure<ScheduleResponseDTO>> updateById(int scheduleId,
			ScheduleRequestDTO scheduleRequest);
	ResponseEntity<ResponseStructure<ScheduleResponseDTO>> findScheduleByschool(int schoolId);
	

}
