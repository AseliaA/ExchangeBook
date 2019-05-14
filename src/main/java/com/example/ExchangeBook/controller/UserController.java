package com.example.ExchangeBook.controller;

import com.example.ExchangeBook.model.Book;
import com.example.ExchangeBook.model.User;
import com.example.ExchangeBook.repository.UserRepository;
import com.example.ExchangeBook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.URL_USER)
public class UserController {
    public static final String URL_USER = "/sprint/exchangeBook/User";
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/sprint/exchangeBook/User/getUserById")//возвращает одного пользователя по id
    public User getOneUser(@PathVariable Long getUserById) {
        return this.userService.getUserById(getUserById);
    }

    @DeleteMapping("/sprint/exchangeBook/User/deleteUserById")//удаляет одного пользователя по id
    public void deleteOneUser(@PathVariable Long deleteUserById) {
        this.userService.deleteUserById(deleteUserById);
    }

    @PostMapping("/sprint/exchangeBook/User/addUser")
    public User createUser(@RequestBody User addUser) {
        return this.userService.addUser(addUser);
    }

    @GetMapping(" /sprint/exchangeBook/User/getAllUsers")
    public List<User> getAllUsers() {
        return this.userService.getAllUser();
    }

  //  @GetMapping("/sprint/exchangeBook/User/getUsersAllBooks")
//    public List<Book> getAllUsersBook(@PathVariable Long getUsersAllBooks) {
//        return this.userRepository.getBook(getUsersAllBooks);
//    }

}
