package com.example.labprj.post.controller;

import com.example.labprj.post.dto.PostSavedto;
import com.example.labprj.post.entity.Post;
import com.example.labprj.post.postRepository.PostRepository;
import com.example.labprj.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class PostController {
    private final PostService postService;
    @GetMapping("homelistdatas")
    public ResponseEntity<String> getList(){

        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }

    @PostMapping("posting")
    public ResponseEntity<String> savePost(@RequestBody final PostSavedto params){
        return  new ResponseEntity<>(postService.savePost(params), HttpStatus.OK);
    }
}
