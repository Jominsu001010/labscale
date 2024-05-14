package com.example.labprj.post.dto;

import com.example.labprj.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@Getter
@NoArgsConstructor
public class PostUpdatedto {
    private String title;
    private String content;
    private String state;
    private int price;
    private String imgUrl;
    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .state(state)
                .price(price)
                .imgUrl(imgUrl)
                .build();
    }
}
