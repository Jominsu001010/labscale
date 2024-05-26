package com.example.labprj.post.controller;

import com.example.labprj.post.dto.PostSavedto;
import com.example.labprj.post.dto.PostUpdatedto;
import com.example.labprj.post.entity.Post;
import com.example.labprj.post.postRepository.PostRepository;
import com.example.labprj.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    @GetMapping
    public ResponseEntity<String> getList(){
        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> savePost(@RequestBody final PostSavedto params){
        return  new ResponseEntity<>(postService.savePost(params), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody final PostUpdatedto params){
        return new ResponseEntity<>(postService.updatePost(id, params), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> detailPost(@PathVariable Long id){
        return new ResponseEntity<>(postService.detailPost(id), HttpStatus.OK);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        return new ResponseEntity<>(postService.deletePost(id), HttpStatus.OK);
    }
}
