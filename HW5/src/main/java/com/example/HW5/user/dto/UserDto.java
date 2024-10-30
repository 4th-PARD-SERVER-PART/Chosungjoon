package com.example.HW5.user.dto;

import com.example.HW5.post.dto.PostDto;
import com.example.HW5.post.entity.Post;
import com.example.HW5.user.entity.User;
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
        private String email;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class detailReq{
        private Long id;
        private String email;
        private List<Post>posts;

        public static detailReq of(User user) {
                return new detailReq(user.getId(),user.getEmail(),user.getPost());
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class detailRes{

        private String email;
        private List<PostDto.createRes>posts;

        public static detailRes of(User user) {
            return new detailRes(user.getEmail(),PostDto.createRes.postList(user.getPost()));
        }




    }


}
