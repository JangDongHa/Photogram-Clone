package com.cos.photogramstart.service;

import com.cos.photogramstart.web.dto.auth.request.SignupDto;

import javax.validation.Valid;

public interface AuthService {
    void signup(SignupDto dto);
}
