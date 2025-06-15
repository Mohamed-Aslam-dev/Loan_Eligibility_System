package com.loan_eligibility_system_chatbot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.loan_eligibility_system_chatbot.dto.PromptRequest;
import com.loan_eligibility_system_chatbot.service.ChatBotService;

@Controller
public class ChatBotWebController {

    private final ChatBotService chatBotService;

    public ChatBotWebController(ChatBotService chatBotService) {
        this.chatBotService = chatBotService;
    }

    // Serve the form page at /ask-question
    @GetMapping("/ask-question")
    public String showChatForm() {
        return "chat";  // maps to /WEB-INF/jsp/chat.jsp
    }

    // Handle form submission at /submit-question
    @PostMapping("/submit-question")
    public String handleChatRequest(@RequestParam String prompt, Model model) {
        String response = chatBotService.getChatResponse(new PromptRequest(prompt));
        model.addAttribute("response", response);
        return "result";  // maps to /WEB-INF/jsp/result.jsp
    }
}

