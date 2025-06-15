package com.loan_eligibility_system_chatbot.dto;

import java.util.List;

public record ResponseDto(List<Choice> choices) {
    public static record Choice(Message message) {
        public static record Message(String role, String content) {}
    }
}

