package com.cos.photogramstart.web.dto.auth.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SignupDto {
    private String username;
    private String password;
    private String email;
    private String name;
}
