package com.cos.photogramstart.web.dto.auth;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ResponseErrorDto<T> {
    private int code; // 1 = 성공, -1 = 실패
    private String message;
    private T data;
}
