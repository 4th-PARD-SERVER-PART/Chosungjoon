package com.example.HW5.post.entity;


import com.example.HW5.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String title;
    @Setter
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public static Post toEntity(String title,String content,User user) {
        return new Post(null,title,content,user);
    }
}
