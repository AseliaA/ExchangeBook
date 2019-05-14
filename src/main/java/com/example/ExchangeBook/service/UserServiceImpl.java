package com.example.ExchangeBook.service;

import com.example.ExchangeBook.model.Book;
import com.example.ExchangeBook.model.User;
import com.example.ExchangeBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User u) {
        return this.userRepository.save(u);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

//    @Override
//    public List<Book> getAllUsersBook(User u) {
//        return this.userRepository.fi;
//    }


    public List<User> getTop100(){
        return userRepository.getRatingOfGenerosity();
    }
    public List<Book>getBook(Long UserId){
        return this.userRepository.getBook(UserId);
    }


}
