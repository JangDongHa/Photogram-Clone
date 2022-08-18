package com.cos.photogramstart.domain.user;

import com.cos.photogramstart.domain.common.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, length = 100)
    private String username;

    private String password;

    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 100)
    private String name;


    @Column(length = 20)
    private String phone;

    @Column(length = 10)
    private String gender;

    private String website; // 웹사이트
    private String bio; // 자기소개

    @Column(length = 50)
    private String role; // 권한
    private String profileImageUrl; // 프로필 사진
}
