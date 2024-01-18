package com.school.SchoolBoardAPI.exception;

public class ScheduleNotFoundByIdException extends RuntimeException {
	private String msg;

	public ScheduleNotFoundByIdException(String msg) {
		super(msg);
		this.msg = msg;
	}
}
