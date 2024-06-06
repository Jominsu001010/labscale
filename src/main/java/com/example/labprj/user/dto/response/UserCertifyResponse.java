package com.example.labprj.user.dto.response;

public record UserCertifyResponse(
        String accessToken,
        String refreshToken,
        Boolean isCertified
) {
    public static UserCertifyResponse from(String accessToken, String refreshToken, Boolean isCertified){
        return new UserCertifyResponse(accessToken, refreshToken, isCertified);
    }
}
