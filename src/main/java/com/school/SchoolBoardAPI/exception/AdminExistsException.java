package com.school.SchoolBoardAPI.exception;

public class AdminExistsException extends RuntimeException {
private String msg;

public AdminExistsException(String msg) {
	this.msg = msg;
}


}
