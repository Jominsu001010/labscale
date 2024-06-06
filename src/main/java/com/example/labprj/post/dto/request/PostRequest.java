package com.example.labprj.post.dto.request;

import com.example.labprj.post.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@AllArgsConstructor
@Getter
@Setter
public class PostRequest {
    private String title;
    private String content;
    private String state;
    private int price;
    private Date creDate;
    private String imgUrl;
    public Post toEntity() {
        return new Post(this.title, this.content, this.state, this.price, this.creDate, this.imgUrl);
    }
}
