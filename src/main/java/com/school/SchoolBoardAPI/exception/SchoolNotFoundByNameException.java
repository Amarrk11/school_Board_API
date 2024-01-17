package com.school.SchoolBoardAPI.exception;

public class SchoolNotFoundByNameException extends RuntimeException {
private String msg ;

public SchoolNotFoundByNameException(String msg) {
	super(msg);
	this.msg = msg;
}

}
