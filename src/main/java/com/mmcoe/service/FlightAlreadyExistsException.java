package com.mmcoe.service;

public class FlightAlreadyExistsException extends RuntimeException{
	/**
	 * @author Esha Sonawane
	 * @version 1.0
	 * @since 2026-07-10
	 */
	public FlightAlreadyExistsException() {
		super();
		
	}

	public FlightAlreadyExistsException(String message) {
		super(message);
		
	}

}
