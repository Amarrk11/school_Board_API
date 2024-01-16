package com.school.SchoolBoardAPI.requestdto;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class SchoolRequestDTO {
	private long schoolContactInfo;
	private String schoolName;
	private String schoolemailId;
	private String schoolAddress;
}
