package com.example.labprj.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class PostResponse<T> {
    private String apiSvcId;
    private HttpStatus resultCode;
    private String resultMessage;
    private T resData;

    public PostResponse(final String apiSvcId, final HttpStatus resultCode, final String resultMessage) {
        this.apiSvcId = apiSvcId;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.resData = null;
    }
    public static<T> PostResponse<T> res(final String apiSvcId,final HttpStatus resultCode, final String resultMessage) {
        return res(apiSvcId, resultCode, resultMessage, null);
    }

    public static<T> PostResponse<T> res(final String apiSvcId, final HttpStatus resultCode, final String resultMessage, final T t) {
        return PostResponse.<T>builder()
                .resData(t)
                .apiSvcId(apiSvcId)
                .resultCode(resultCode)
                .resultMessage(resultMessage)
                .build();
    }
}
