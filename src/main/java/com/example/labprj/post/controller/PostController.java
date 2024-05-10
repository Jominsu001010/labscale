package com.example.labprj.post.controller;

import com.example.labprj.post.postRepository.PostRepository;
import com.example.labprj.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class PostController {
    private final PostService postService;
    @GetMapping("homelistdatas")
    public ResponseEntity<String> getList(){

        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }
}
