package com.example.seminar4.card.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CardRequest {
    @Getter
    @Builder
    @AllArgsConstructor@NoArgsConstructor
    public static class CardCreateRequest{
        private String name;
        private Long userId;
    }
}
