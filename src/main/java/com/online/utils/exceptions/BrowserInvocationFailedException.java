package com.online.utils.exceptions;

@SuppressWarnings("serial")
public class BrowserInvocationFailedException extends FrameWorkException{

	public BrowserInvocationFailedException(String message) {
		super(message);
		System.exit(0);
	}
	public BrowserInvocationFailedException(String message,Throwable cause) {
		super(message,cause);
		System.exit(0);

	}

}
