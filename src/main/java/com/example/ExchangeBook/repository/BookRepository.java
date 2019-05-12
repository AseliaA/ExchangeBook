package com.example.ExchangeBook.repository;

import com.example.ExchangeBook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
