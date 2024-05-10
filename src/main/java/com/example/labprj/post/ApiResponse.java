package com.example.labprj.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String apiSvcId;
    private String resultCode;
    private String resultMessage;
    private T resData;

}
