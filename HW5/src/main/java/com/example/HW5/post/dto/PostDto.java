package com.example.HW5.post.dto;

import com.example.HW5.post.entity.Post;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


public class PostDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    public static class createReq{
        private String title;
        private String content;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class deleteReq{
        private Long postId;

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createRes{
        private Long PostId;
        private String title;
        private String content;

        public static List<PostDto.createRes>postList(List<Post>posts){
            List<PostDto.createRes> resList = new ArrayList<>();
            for(Post post : posts){
                PostDto.createRes res = new PostDto.createRes(post.getId(),post.getTitle(),post.getContent());
                resList.add(res);
            }
            return resList;
        }
    }
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class updateReq{
        private Long postId;
        private String title;
        private String content;
    }
}
