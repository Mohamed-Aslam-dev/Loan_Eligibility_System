package com.loan_eligibility_system_homeloan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan_eligibility_system_homeloan.requestDTO.HomeloanApplyRequestDTO;
import com.loan_eligibility_system_homeloan.service_repository.HomeloanApplyServiceRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/loan")
public class HomeloanApplyDataController {

	private HomeloanApplyServiceRepository homeloanApplyServiceRepository;
	
	public HomeloanApplyDataController(HomeloanApplyServiceRepository homeloanApplyServiceRepository) {
		
		this.homeloanApplyServiceRepository = homeloanApplyServiceRepository;
	}

	@PostMapping("/apply")
	public ResponseEntity<?> applyLoan(@RequestBody @Valid HomeloanApplyRequestDTO newLoanApplyData){
		return ResponseEntity.status(HttpStatus.OK).body(homeloanApplyServiceRepository.applyLoan(newLoanApplyData));
	}
	
}
