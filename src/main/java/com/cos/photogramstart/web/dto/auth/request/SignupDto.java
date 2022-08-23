package com.cos.photogramstart.web.dto.auth.request;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.web.dto.message.SignupNaming;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SignupDto {
    @NotBlank(message = SignupNaming.USERNAME_NOT_BLANK)
    @Size(min = 4, max = 20, message = SignupNaming.USERNAME_SIZE_ISSUE)
    private String username;

    @NotBlank(message = SignupNaming.PASSWORD_NOT_BLANK)
    private String password;
    @NotBlank(message = SignupNaming.EMAIL_NOT_BLANK)
    private String email;
    @NotBlank(message = SignupNaming.NAME_NOT_BLANK)
    private String name;


    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name).build();
    }
}
