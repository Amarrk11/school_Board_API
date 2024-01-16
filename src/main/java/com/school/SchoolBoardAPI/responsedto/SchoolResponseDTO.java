package com.school.SchoolBoardAPI.responsedto;

import com.school.SchoolBoardAPI.entity.Schedule;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter

public class SchoolResponseDTO {
	private int schoolId;	
	private long schoolContactInfo;
	private String schoolName;
	private String schoolemailId;
	private String schoolAddress;
}
