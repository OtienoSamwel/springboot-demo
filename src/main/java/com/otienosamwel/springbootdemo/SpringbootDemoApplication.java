package com.otienosamwel.springbootdemo;

import com.otienosamwel.springbootdemo.domain.model.User;
import com.otienosamwel.springbootdemo.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemoApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    public SpringbootDemoApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        userRepository.save(new User(1, "Mark", "Daniel", 21, "developer"));
        userRepository.save(new User(2, "David", "Blaine", 21, "advocate"));
        userRepository.save(new User(3, "Mark", "Thorn", 21, "data scientist"));
    }
}
