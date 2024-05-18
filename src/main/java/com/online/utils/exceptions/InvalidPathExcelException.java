package com.online.utils.exceptions;

@SuppressWarnings("serial")
public class InvalidPathExcelException extends FrameWorkException{

	public InvalidPathExcelException(String message){
		super(message);
	}
	public InvalidPathExcelException(String message ,Throwable cause){
		super(message,cause);
	}
}
