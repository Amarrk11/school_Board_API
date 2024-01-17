package com.school.SchoolBoardAPI.serviceImpl;

public class AdminExistsException extends RuntimeException {
private String msg;

public AdminExistsException(String msg) {
	this.msg = msg;
}


}
