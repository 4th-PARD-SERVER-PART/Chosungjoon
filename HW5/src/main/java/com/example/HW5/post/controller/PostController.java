package com.example.HW5.post.controller;

import com.example.HW5.post.dto.PostDto;
import com.example.HW5.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("create/{email}")
    public void createPost(@PathVariable String email,@RequestBody PostDto.createReq request) {
        postService.createPost(email,request);
    }
    @GetMapping("/detail/{postId}")
    PostDto.createRes detailPost(long postId){
        return postService.detailPost(postId);
    }

    @PatchMapping("update/{email}")
    public void updatePost(@PathVariable String email,@RequestBody PostDto.updateReq request){
        postService.updatePost(email,request);
    }
    @DeleteMapping("/delete/{email}")
    public void deletePost(@PathVariable String email,@RequestBody PostDto.deleteReq request){
        postService.deletePost(email,request);
    }

}

