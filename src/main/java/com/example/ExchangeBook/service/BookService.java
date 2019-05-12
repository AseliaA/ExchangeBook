package com.example.ExchangeBook.service;

import com.example.ExchangeBook.enums.State;
import com.example.ExchangeBook.model.Book;
import com.example.ExchangeBook.model.Exchange;
import com.example.ExchangeBook.model.User;
import com.example.ExchangeBook.repository.BookRepository;
import com.example.ExchangeBook.repository.ExchangeRepository;
import com.example.ExchangeBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ExchangeRepository exchangeRepository;
    @Autowired
    private UserRepository userRepository;



}
