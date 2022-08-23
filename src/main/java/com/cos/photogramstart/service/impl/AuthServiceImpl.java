package com.cos.photogramstart.service.impl;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.request.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void signup(SignupDto dto){
        //validation(dto.getUsername());
        dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        User user = dto.toEntity();


        userRepository.save(user);
    }

    private void validation(String nickname){
        try{
            Optional.ofNullable(nickname)
                    .filter(Predicate.not(String::isBlank))
                    .filter(Predicate.not(s -> s.length() >= 4 && s.length() <= 20))
                    .orElseThrow(IllegalArgumentException::new);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("닉네임 길이는 4 ~ 20 자 사이여야 합니다.");
        }
    }
}
