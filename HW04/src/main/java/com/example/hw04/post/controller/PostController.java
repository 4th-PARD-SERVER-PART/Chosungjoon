package com.example.hw04.post.controller;

import com.example.hw04.post.dto.PostDto;
import com.example.hw04.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("create/{userId}")
    public void createPost(@PathVariable Long userId ,@RequestBody PostDto.createReq request) {
        postService.createPost(userId,request);
    }
    @GetMapping("/detail/{postId}")
    PostDto.createRes detailPost(@PathVariable Long postId){
        return postService.detailPost(postId);
    }
    @PatchMapping("update/{userId}")
    public void updatePost(@PathVariable Long userId,@RequestBody PostDto.updateReq request){
        postService.updatePost(userId,request);
    }
    @DeleteMapping("/delete/{userId}")
    public void deletePost(@PathVariable Long userId,@RequestBody PostDto.deleteReq request){
        postService.deletePost(userId,request);
    }

}

