package com.example.hw04.user.dto;

import com.example.hw04.post.dto.PostDto;
import com.example.hw04.post.entity.Post;
import com.example.hw04.user.entity.User;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDto {


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createReq{
        private String username;
        private String password;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class detailReq{
        private Long id;
        private String username;
        private List<Post>posts;

        public static detailReq of(User user) {
                return new detailReq(user.getId(),user.getUsername(),user.getPost());
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class detailRes{

        private String username;
        private List<PostDto.createRes>posts;

        public static detailRes of(User user) {
            return new detailRes(user.getUsername(),PostDto.createRes.postList(user.getPost()));
        }




    }


}
