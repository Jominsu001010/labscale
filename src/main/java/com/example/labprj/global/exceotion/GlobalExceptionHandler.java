package com.example.labprj.global.exceotion;

import com.example.labprj.post.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handlePostNotFoundException(PostNotFoundException ex) {
        ApiResponse<String> response = new ApiResponse<>();
        response.setApiSvcId("CM02");
        response.setResultCode("404");
        response.setResultMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

