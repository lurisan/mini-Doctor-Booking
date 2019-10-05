package com.exception;

public class DoctorAlreadyMappedException extends Exception {
	private static final long serialVersionUID = 1L;

	public DoctorAlreadyMappedException(String message)
	{
		super(message);
	}

}
