
package com.loan_eligibility_system_chatbot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan_eligibility_system_chatbot.dto.PromptRequest;
import com.loan_eligibility_system_chatbot.service.ChatBotService;

@RestController
@RequestMapping("/api/chat")
public class ChatBotController {

    private final ChatBotService chatBotService;

    public ChatBotController(ChatBotService chatBotService) {
        this.chatBotService = chatBotService;
    }

    @PostMapping
    public String chat(@RequestBody PromptRequest promptRequest) {
        return chatBotService.getChatResponse(promptRequest);
    }

    @GetMapping("/chat")
    public String getchat() {
        return "chat"; // loads chat.jsp from WEB-INF/views
    }

}

