package com.example.testproject.repository;

import com.example.testproject.entity.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BlogUserRepository extends JpaRepository<BlogUser, UUID> {

    public Optional<BlogUser> findByEmail(String email);
}
