package com.example.labprj.post.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private Date creDate;

    @Column
    private String imgUrl;

    public Post(String title, String content, String state, int price, Date creDate, String imgUrl) {
        this.title = title;
        this.content = content;
        this.state = state;
        this.price = price;
        this.creDate = creDate;
        this.imgUrl = imgUrl;
    }
}
