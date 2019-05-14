package com.example.ExchangeBook.bootstrap;//package com.example.ExchangeBook.bootstrap;
import com.example.ExchangeBook.enums.Language;
import com.example.ExchangeBook.enums.State;
import com.example.ExchangeBook.model.Book;
import com.example.ExchangeBook.model.User;
import com.example.ExchangeBook.model.UserRoles;
import com.example.ExchangeBook.repository.BookRepository;
import com.example.ExchangeBook.repository.UserRepository;
import com.example.ExchangeBook.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MainBootstrap implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRolesRepository userRolesRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user1  = new User("Shabdan","shaba",passwordEncoder.encode("123"),1,"996550523209",1233);
        userRepository.save(user1);
        UserRoles userRoles1 = new UserRoles("ROLE_USER", user1);
        userRolesRepository.save(userRoles1);



    }

}