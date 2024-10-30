package com.example.HW5.post.service;

import com.example.HW5.post.dto.PostDto;
import com.example.HW5.post.entity.Post;
import com.example.HW5.post.repository.PostRepository;
import com.example.HW5.user.entity.User;
import com.example.HW5.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void createPost(Long userId, PostDto.createReq req){
        Optional<User> users=userRepository.findById(userId);
        User user=users.get();
        Post post=Post.toEntity(req.getTitle(),req.getContent(),user);
        postRepository.save(post);
    }

    public PostDto.createRes detailPost(Long postId) {
        Optional<Post> posts=postRepository.findById(postId);
        Post post=posts.get();
            return new PostDto.createRes(postId,post.getTitle(), post.getContent());
    }
    public void updatePost(Long userId,PostDto.updateReq req){
        Optional<Post> posts=postRepository.findById(req.getPostId());
        Post post=posts.get();
        if(post.getUser().getId().equals(userId)){
        post.setTitle(req.getTitle());
        post.setContent(req.getContent());
        postRepository.save(post);
        }
    }
    public void deletePost(Long userId,PostDto.deleteReq req){
        Optional<User> users=userRepository.findById(userId);
        User user=users.get();
        Optional<Post> posts=postRepository.findById(req.getPostId());
        Post post=posts.get();
        if(post.getUser().getId().equals(user.getId())) {
            postRepository.delete(post);
        }
    }



}
