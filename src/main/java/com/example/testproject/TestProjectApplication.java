package com.example.testproject;

import com.example.testproject.entity.BlogUser;
import com.example.testproject.entity.Post;
import com.example.testproject.repository.BlogUserRepository;
import com.example.testproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class TestProjectApplication implements CommandLineRunner {

    private final PostRepository postRepository;
    private final BlogUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(TestProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Post> postList = List.of(
                new Post(UUID.randomUUID(), "title1", "content1", "soo", LocalDateTime.now()),
                new Post(UUID.randomUUID(), "title2", "content2", "soo", LocalDateTime.now()),
                new Post(UUID.randomUUID(), "title3", "content3", "soo", LocalDateTime.now())
        );

        postRepository.saveAll(postList);

        List<BlogUser> userList = List.of(
                BlogUser.builder().email("sooyoung159@naver.com").password(passwordEncoder.encode("1234")).name("sooyoung").build()
        );
        userRepository.saveAll(userList);
    }


}
