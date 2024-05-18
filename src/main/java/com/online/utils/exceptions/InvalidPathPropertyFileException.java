package com.online.utils.exceptions;

@SuppressWarnings("serial")
public class InvalidPathPropertyFileException extends FrameWorkException {

	public InvalidPathPropertyFileException(String message) {
		super(message);
	}
	public InvalidPathPropertyFileException(String message,Throwable cause) {
		super(message,cause);
	}
}
