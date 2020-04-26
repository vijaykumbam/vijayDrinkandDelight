package com.capgemini.drinkanddelight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.drinkanddelight.entity.ProductOrderEntity;

@RestControllerAdvice
public class CenterExceptionHandler {

	
	@ExceptionHandler(value=ProductOrderEntityException.class)
	public ResponseEntity<Object> productorderentityexception(ProductOrderEntity obj){
		return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
	}
}
