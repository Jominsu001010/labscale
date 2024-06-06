package com.example.labprj.post.controller;

import com.example.labprj.post.dto.request.PostRequest;
import com.example.labprj.post.dto.response.PostResponse;
import com.example.labprj.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    @GetMapping
    public PostResponse getList(){
        return  postService.getAllPost();
    }

    @PostMapping("/create")
    public PostResponse savePost(@RequestBody final PostRequest params){
        return  postService.savePost(params);
    }
   /*@PutMapping("/{id}")
    public PostResponse updatePost(@PathVariable Long id, @RequestBody final PostUpdatedto params){
        return postService.updatePost(id, params);
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> detailPost(@PathVariable Long id){
        return new ResponseEntity<>(postService.detailPost(id), HttpStatus.OK);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        return new ResponseEntity<>(postService.deletePost(id), HttpStatus.OK);
    }*/
}
