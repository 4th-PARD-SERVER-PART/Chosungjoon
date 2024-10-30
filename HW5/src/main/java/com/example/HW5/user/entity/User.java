package com.example.HW5.user.entity;

import com.example.HW5.post.entity.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Post> post;

    @Column(unique = true, nullable = false)
    @Setter
    private String email;
    @Setter
    private String name;
    @Setter
    private String givenName;
    @Setter
    private String familyName;
    @Setter
    private String pictureUrl;
}
