package com.loan_eligibility_system_chatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.loan_eligibility_system_chatbot.dto.PromptRequest;
import com.loan_eligibility_system_chatbot.dto.RequesttDTO;
import com.loan_eligibility_system_chatbot.dto.ResponseDto;

@Service
public class ChatBotService {

    private final RestClient restClient;

    @Value("${openapi.api.key}")
    private String apiKey;

    @Value("${openapi.api.model}")
    private String model;

    public ChatBotService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String getChatResponse(PromptRequest promptRequest) {
        RequesttDTO requestDTO = new RequesttDTO(
            model,
            List.of(new RequesttDTO.Message("user", promptRequest.prompt()))
        );

        ResponseDto response = restClient.post()
            .uri("") // Uses base URL from configuration
            .header("Authorization", "Bearer " + apiKey)
            .header("Content-Type", "application/json")
            .body(requestDTO)
            .retrieve()
            .body(ResponseDto.class);

        return response.choices().get(0).message().content();
    }
}

