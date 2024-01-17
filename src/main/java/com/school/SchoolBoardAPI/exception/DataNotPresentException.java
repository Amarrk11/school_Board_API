package com.school.SchoolBoardAPI.exception;

public class DataNotPresentException extends RuntimeException {
	private String msg;

	public DataNotPresentException(String msg) {
		super(msg);
		this.msg = msg;
	}
	

}
