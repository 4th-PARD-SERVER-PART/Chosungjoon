package com.example.HW5.post.repository;

import com.example.HW5.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser_Email(String email);  // 수정된 부분
}
