package com.example.labprj.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    private Long id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String local;

    @Column
    private String proFileImg;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    public User(String email, String password, Authority authority) {
        this.email = email;
        this.password = password;
        this.authority = authority;
    }

}
