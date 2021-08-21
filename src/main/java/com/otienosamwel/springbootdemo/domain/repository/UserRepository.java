package com.otienosamwel.springbootdemo.domain.repository;

import com.otienosamwel.springbootdemo.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
