package com.infogain.rewardsapi.exception;

public class NoOrdersFoundException extends RuntimeException {

	private static final long serialVersionUID = 5789550227071826564L;

	public NoOrdersFoundException(String message) {
		super(message);
	}

}
