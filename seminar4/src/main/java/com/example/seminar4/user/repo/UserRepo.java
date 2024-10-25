package com.example.seminar4.user.repo;

import com.example.seminar4.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {
}
