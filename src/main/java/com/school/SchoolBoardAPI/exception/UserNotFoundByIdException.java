package com.school.SchoolBoardAPI.exception;

public class UserNotFoundByIdException extends RuntimeException{
private String msg;

public UserNotFoundByIdException(String msg) {
	super(msg);
	this.msg = msg;
}

}
