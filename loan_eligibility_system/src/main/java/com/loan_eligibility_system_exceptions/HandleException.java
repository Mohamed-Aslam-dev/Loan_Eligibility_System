package com.loan_eligibility_system_exceptions;

import java.util.HashMap;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class HandleException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException validException) {

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

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> enumFoundExceptionHandler(HttpMessageNotReadableException validException) {
		
		return new ResponseEntity<>(validException.getMessage(), HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(IllegalStateException.class)
    public String handleSessionExpiredError(IllegalStateException ex, Model model) {
		model.addAttribute("errorMessage", "Session expired! Please start the loan application again.");
        return "HomeLoan/SessionExpiredPage"; // create this JSP
    }
	
	@ExceptionHandler(YourExistingQueryRaiserException.class)
	public String ExistingQueryRaiserException(YourExistingQueryRaiserException exception, Model model) {
		
		model.addAttribute("errorMessage", exception.getMessage());
        return "ExistingQueryError";
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
    public String handleConstraintViolation(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Invalid query type. Please select a valid option.");
        return "AnyQueries"; // or redirect to form with previous data
    }

}
