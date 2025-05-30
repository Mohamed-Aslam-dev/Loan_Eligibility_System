package com.loan_eligibility_system_exceptions;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class HandleException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException validException){
		
		HashMap<String, String> exceptionMap = new HashMap<>();
		
		validException.getBindingResult().getAllErrors().forEach((exception) -> {
			String errorField = ((FieldError) exception).getField();
			String errorMessage = exception.getDefaultMessage();
			exceptionMap.put(errorField, errorMessage);
		});
		
		return new ResponseEntity<>(exceptionMap, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(LoanNotFoundException.class)
	public ResponseEntity<?> loanNotFoundExceptionHandler(LoanNotFoundException validException) {

		return new ResponseEntity<>(validException.getMessage(), HttpStatus.BAD_REQUEST);

	}

	//Enum class exception
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> enumFoundExceptionHandler(HttpMessageNotReadableException validException) {
		
		return new ResponseEntity<>(validException.getMessage(), HttpStatus.BAD_REQUEST);

	}

}
