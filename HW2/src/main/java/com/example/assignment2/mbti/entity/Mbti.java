package com.example.assignment2.mbti.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mbti {
    private String mbti_type;
    private String mbti_nick;
}
