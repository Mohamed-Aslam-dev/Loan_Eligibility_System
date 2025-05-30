package com.loan_eligibility_system_homeloan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyHomeDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyIncomeDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyLoanDTO;
import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyPersonalDTO;
import com.loan_eligibility_system_homeloan.service_repository.HomeloanApplyServiceRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/loan/apply")
public class HomeloanApplyDataController {

	private HomeloanApplyServiceRepository homeloanApplyServiceRepository;
	
	public HomeloanApplyDataController(HomeloanApplyServiceRepository homeloanApplyServiceRepository) {
		
		this.homeloanApplyServiceRepository = homeloanApplyServiceRepository;
	}

	@PostMapping("/personaldata")
	public ResponseEntity<?> applyPersonalData(@RequestBody @Valid HomeloanApplyPersonalDTO newLoanApplyPersonalData){
		return ResponseEntity.status(HttpStatus.OK).body(homeloanApplyServiceRepository.applyPersonalData(newLoanApplyPersonalData));
	}
	@PostMapping("/incomedata")
	public ResponseEntity<?> applyIncomeData(@RequestBody @Valid HomeloanApplyIncomeDTO newLoanApplyIncomeData){
		return ResponseEntity.status(HttpStatus.OK).body(homeloanApplyServiceRepository.applyIncomeData(newLoanApplyIncomeData));
	}
	@PostMapping("/homedata")
	public ResponseEntity<?> applyHomeData(@RequestBody @Valid HomeloanApplyHomeDTO newLoanApplyHomeData){
		return ResponseEntity.status(HttpStatus.OK).body(homeloanApplyServiceRepository.applyHomeData(newLoanApplyHomeData));
	}
	@PostMapping("/loandata")
	public ResponseEntity<?> applyLoanData(@RequestBody @Valid HomeloanApplyLoanDTO newLoanApplyLoanData){
		return ResponseEntity.status(HttpStatus.OK).body(homeloanApplyServiceRepository.applyLoanData(newLoanApplyLoanData));
	}
	
	
}
