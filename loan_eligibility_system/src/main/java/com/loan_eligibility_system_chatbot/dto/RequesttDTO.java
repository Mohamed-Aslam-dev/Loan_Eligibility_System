package com.loan_eligibility_system_chatbot.dto;

import java.util.List;

public record RequesttDTO(String model, List<Message> messages) {
    public static record Message(String role, String content) {}
}
