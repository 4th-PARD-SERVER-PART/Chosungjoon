package com.example.assignment2.mbti.entity;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Mbti {
    @Setter
    private String mbti_type;
    @Setter
    private String mbti_nick;


}
