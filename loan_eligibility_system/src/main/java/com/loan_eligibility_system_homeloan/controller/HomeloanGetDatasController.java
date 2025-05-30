package com.loan_eligibility_system_homeloan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan_eligibility_system_homeloan.service_repository.HomeloanApplyServiceRepository;

@RestController
@RequestMapping("/loan/get")
public class HomeloanGetDatasController {
	
	private HomeloanApplyServiceRepository homeloanApplyServiceRepository;
	
	public HomeloanGetDatasController(HomeloanApplyServiceRepository homeloanApplyServiceRepository) {
		
		this.homeloanApplyServiceRepository = homeloanApplyServiceRepository;
	}
	
	@GetMapping("/getdetails/{id}")
	public ResponseEntity<?> getLoan(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(homeloanApplyServiceRepository.getTheLoanDetails(id));
	}

}
