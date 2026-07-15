package com.mmcoe.service;

public class FlightAlreadyExistsException extends RuntimeException{

	public FlightAlreadyExistsException() {
		super();
		
	}

	public FlightAlreadyExistsException(String message) {
		super(message);
		
	}

}
