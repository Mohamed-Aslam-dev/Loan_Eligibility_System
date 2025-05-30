package com.loan_eligibility_system_exceptions;

public class LoanNotFoundException extends RuntimeException{
	
	public LoanNotFoundException(){
		super();
	}
	
	public LoanNotFoundException(String message) {
		super(message);
	}

}
