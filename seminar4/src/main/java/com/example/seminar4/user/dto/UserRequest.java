package com.example.seminar4.user.dto;

import com.example.seminar4.book.entity.Book;
import com.example.seminar4.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserRequest {

    @Getter
    @Builder
    @NoArgsConstructor@AllArgsConstructor
    public static class UserReadRequest{
        private Long id;
        private String name;
        private List<Book>books;

        public static UserReadRequest from(User user){
            return new UserReadRequest(user.getId(),user.getName(),user.getBook());
        }
    }

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NoArgsConstructor@AllArgsConstructor
    public static class UserCreateRequest{
        private String name;
        private List<Book>books;
    }
}
