package com.example.labprj.user.userRepository;


import com.example.labprj.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByname(String name);
}
