package com.loan_eligibility_system_any_queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/queries")
public class AnyQueriesController {
	
	@Autowired
	private AnyQueriesService anyQueriesService;
	
	private String lastGeneratedToken;
	
	@GetMapping("/anyQuery")
	public String accessAnyQueryPage(@ModelAttribute("anyQueries") AnyQueriesDTO anyQueries, Model model) {
		
		model.addAttribute("QueriesType", QueriesType.values());
		
		return "AnyQueries";
	}
	
	@GetMapping("/confirmation")
	public String queryConfirmationAccessPage(Model model) {
		// Pass the token to confirmation page
		model.addAttribute("tokenId", lastGeneratedToken);
		return "QueryConfirmation";
	}

	@PostMapping("/add")
	public String addNewQueries(@Valid @ModelAttribute("anyQueries") AnyQueriesDTO newQueries, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("QueriesType", QueriesType.values());
			return "AnyQueries";
		}
		
		lastGeneratedToken = anyQueriesService.addToNewQuery(newQueries);
		
		return "redirect:/queries/confirmation";
	}
	
}
