package com.school.SchoolBoardAPI.exception;

public class SchoolNotFoundByIdException extends RuntimeException {
	private String message;

	public SchoolNotFoundByIdException(String message) {
		super(message);
		this.message = message;
	}

}
