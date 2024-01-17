package com.school.SchoolBoardAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.SchoolBoardAPI.requestdto.ScheduleRequestDTO;
import com.school.SchoolBoardAPI.responsedto.ScheduleResponseDTO;
import com.school.SchoolBoardAPI.service.ScheduleService;
import com.school.SchoolBoardAPI.utility.ResponseStructure;

@RestController
public class ScheduleController {
@Autowired 
private ScheduleService scheduleService;

@PostMapping("/schools/{schoolId}/schedules")
public ResponseEntity<ResponseStructure<ScheduleResponseDTO>> addSchedlue(@PathVariable int schoolId,
		@RequestBody ScheduleRequestDTO scheduleRequest){
	return scheduleService.addSchedlue( schoolId, scheduleRequest);
}
}
