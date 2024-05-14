package com.example.labprj.post.service;

import com.example.labprj.post.ApiResponse;
import com.example.labprj.post.dto.PostSavedto;
import com.example.labprj.post.dto.PostUpdatedto;
import com.example.labprj.post.entity.Post;
import com.example.labprj.post.postRepository.PostRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Transactional(readOnly = true)
    public String getAllPost() {
        List<Post> postList = postRepository.findAll();

        // ApiResponse 객체 생성
        ApiResponse<List<Post>> response = new ApiResponse<>();
        response.setApiSvcId("CM01");
        response.setResultCode("200");
        response.setResultMessage("성공적으로 호출되었습니다");

        // Post 객체 리스트를 ApiResponse의 resData에 설정
        response.setResData(postList);

        // ObjectMapper를 사용하여 ApiResponse를 JSON 문자열로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // 예외 처리
            return "{}";
        }
    }
    public String savePost(final PostSavedto params){
            postRepository.save(params.toEntity());
            ApiResponse<List<Post>> response = new ApiResponse<>();
            response.setApiSvcId("CM02");
            response.setResultCode("200");
            response.setResultMessage("성공적으로 저장되었습니다");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // 예외 처리
            return "{}";
        }
    }

    public String updatePost(Long id, final PostUpdatedto params) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();

            // 새로운 내용으로 기존의 게시글을 업데이트합니다.
            existingPost.setTitle(params.getTitle());
            existingPost.setPrice(params.getPrice());
            existingPost.setState(params.getState());
            existingPost.setContent(params.getContent());

            // 업데이트된 게시글을 저장합니다.
            postRepository.save(existingPost);

            ApiResponse<String> response = new ApiResponse<>();
            response.setApiSvcId("CM02");
            response.setResultCode("200");
            response.setResultMessage("성공적으로 업데이트되었습니다.");

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(response);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                // 예외 처리
                return "{}";
            }
        } else {
            // 해당 id에 해당하는 게시글을 찾을 수 없는 경우
            ApiResponse<String> response = new ApiResponse<>();
            response.setApiSvcId("CM02");
            response.setResultCode("404");
            response.setResultMessage("해당 id에 해당하는 게시글을 찾을 수 없습니다.");

            // ApiResponse를 JSON 문자열로 변환하여 반환합니다.
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(response);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                // 예외 처리
                return "{}";
            }
        }
    }
}
