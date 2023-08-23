package com.crudoperation.customer.exceptionhandler;

/**
 * <b>ExceptionHandler</b> : Thrown customize error
 * 
 * @author Kartik
 */
@SuppressWarnings("serial")
public class ExceptionHandler extends Exception {

	public ExceptionHandler(String exception) {
		super(exception);
	}

}