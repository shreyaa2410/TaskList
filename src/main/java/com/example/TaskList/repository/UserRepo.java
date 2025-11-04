package com.example.TaskList.repository;

import com.example.TaskList.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    public boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
