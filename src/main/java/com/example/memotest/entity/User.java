package com.example.memotest.entity;

import com.example.memotest.dto.SignUpDto;
import com.example.memotest.enums.RoleType;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Builder
    public User(Long id, String name, String email, String password, RoleType role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
