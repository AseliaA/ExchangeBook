package com.example.ExchangeBook.service;

import com.example.ExchangeBook.model.Book;
import com.example.ExchangeBook.model.User;

import java.util.List;

public interface UserService {
    User addUser(User u);

    List<User> getAllUser();

    User getUserById(Long id);

    void deleteUserById(Long id);

   // List<Book> getAllUsersBook(User u);

}
