package com.example.seminar2nd.user.entity;


import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long studentId;
    private String studentName;
}
