package com.example.labprj.post;

import com.example.labprj.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String apiSvcId;
    private String resultCode;
    private String resultMessage;
    private Post Data;
    private T resData;

}
