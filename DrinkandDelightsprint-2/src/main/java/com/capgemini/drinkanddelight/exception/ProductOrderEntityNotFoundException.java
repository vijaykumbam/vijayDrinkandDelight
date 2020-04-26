package com.capgemini.drinkanddelight.exception;

public class ProductOrderEntityNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductOrderEntityNotFoundException(String msg) {
		super(msg);
	}

}
