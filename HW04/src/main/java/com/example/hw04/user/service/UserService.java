package com.example.hw04.user.service;
import com.example.hw04.post.dto.PostDto;
import com.example.hw04.post.entity.Post;
import com.example.hw04.post.repository.PostRepository;
import com.example.hw04.user.dto.UserDto;
import com.example.hw04.user.entity.User;
import com.example.hw04.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;


    public void createUser(UserDto.createReq userReq){
        User user=new User();
        user.setUsername(userReq.getUsername());
        user.setPassword(userReq.getPassword());
        userRepository.save(user);
    }
    public UserDto.detailRes detail(Long userId){
        User user=userRepository.findById(userId).orElse(null);
        UserDto.detailRes detailRes=new UserDto.detailRes();
        detailRes.setUsername(user.getUsername());
        detailRes.setPosts(PostDto.createRes.postList(user.getPost()));
        return detailRes;
    }
    public List<PostDto.createReq> list(Long userId){
        User user=userRepository.findById(userId).orElse(null);
        List<PostDto.createReq> posts=new ArrayList<>();
        if(user!=null){
            List<Post> userPosts = postRepository.findByUserId(userId);
            for (Post post : userPosts) {
                PostDto.createReq detail= new PostDto.createReq();
                detail.setTitle(post.getTitle());
                detail.setContent(post.getContent());
                // 필요에 따라 추가 필드 설정
                posts.add(detail);
            }
        }
        return posts;
    }




}
