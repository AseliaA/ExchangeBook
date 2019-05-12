package com.example.ExchangeBook.repository;

import com.example.ExchangeBook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
