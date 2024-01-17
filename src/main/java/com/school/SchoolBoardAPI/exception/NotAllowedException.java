package com.school.SchoolBoardAPI.exception;

public class NotAllowedException extends RuntimeException {
	private String msg;

	public NotAllowedException(String msg) {
		super(msg);
		this.msg = msg;
	}
	

}
