 package com.loan_eligibility_system_chatbot.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class OpenConfiguration {
	@Value("${open.api.api.url}")
	private String apiurl;


    @Bean
    RestClient restclient() {
		return RestClient.builder()
				.baseUrl(apiurl)
				.build();
	}
} 