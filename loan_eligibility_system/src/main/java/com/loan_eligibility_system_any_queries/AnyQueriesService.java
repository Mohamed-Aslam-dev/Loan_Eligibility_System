package com.loan_eligibility_system_any_queries;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan_eligibility_system_email_verification.EmailSenderService;
import com.loan_eligibility_system_exceptions.YourExistingQueryRaiserException;

@Service
public class AnyQueriesService {

	@Autowired
	private AnyQueriesRepository anyQueriesRepository;
	
	@Autowired
	private EmailSenderService emailSenderService;

	public String addToNewQuery(AnyQueriesDTO newQuery) {
		
		Optional<AnyQueries> existing = anyQueriesRepository.findByEmail(newQuery.getEmail());

		if (existing.isPresent()) {
			throw new YourExistingQueryRaiserException("You have already raised a query...");  // defensive null check
		}
	    AnyQueries anyQuery = new AnyQueries();
	    

	    anyQuery.setUserName(newQuery.getUserName());
	    anyQuery.setEmail(newQuery.getEmail());
	    anyQuery.setQueryType(newQuery.getQueryType());

	    // Generate a new tokenId
	    String token = generateTokenId();
	    anyQuery.setTokenId(token);

	    anyQuery.setMessage(newQuery.getMessage());
	    anyQuery.setQueryRaisedDateAndTime(LocalDateTime.now());
	    
	    anyQuery.setQueryStatus(QueriesStatus.PENDING);

	    anyQueriesRepository.save(anyQuery);

	    emailSenderService.sendQueryRaisedMessageToEmail(anyQuery.getEmail(), anyQuery.getTokenId(), anyQuery.getUserName());
	    
	    return token;
	}
	

	private String generateTokenId() {

		int year = LocalDate.now().getYear();
		String random = UUID.randomUUID().toString().substring(0, 8).toUpperCase();

		return year + random;
	}

}
