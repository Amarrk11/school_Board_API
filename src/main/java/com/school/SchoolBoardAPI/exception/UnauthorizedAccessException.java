package com.school.SchoolBoardAPI.exception;

public class UnauthorizedAccessException extends RuntimeException {
	private String msg;

	public UnauthorizedAccessException(String msg) {
		super(msg);
		this.msg = msg;
	}
}
