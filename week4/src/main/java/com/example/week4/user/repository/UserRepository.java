package com.example.week4.user.repository;

import com.example.week4.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {

   User findByEmail(String email);



}
