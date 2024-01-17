package com.school.SchoolBoardAPI.exception;

public class OnlyAdminAccess extends RuntimeException {
	private String msg;

	public OnlyAdminAccess(String msg) {
		super(msg);
		this.msg = msg;
	}
}
