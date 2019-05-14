package com.example.ExchangeBook.bootstrap;//package com.example.ExchangeBook.bootstrap;
import com.example.ExchangeBook.model.User;
import com.example.ExchangeBook.model.UserRoles;
import com.example.ExchangeBook.repository.UserRepository;
import com.example.ExchangeBook.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MainBootstrap implements CommandLineRunner {
    //    @Override
//    public void run(String... args) throws Exception {
//
//    }
//
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRolesRepository userRolesRepository;

    //
//
    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        User user1 = new User("Elvira", "user1",
//                passwordEncoder.encode("123"), 1);
//        userRepository.save(user1);
//
//        User user2 = new User("Aselia", "user2",
//                passwordEncoder.encode("123"), 1);
//        userRepository.save(user2);
//
//        User user3 = new User("Shabdan", "user3",
//                passwordEncoder.encode("123"), 1);
//        userRepository.save(user3);
        //String name, String login, String password, int isActive, String phoneNumber, int ratingOfGenerosity)
        User user1  = new User("Shabdan","shaba","123",1,"996550523209",1233);
        userRepository.save(user1);
        UserRoles userRoles1 = new UserRoles("ROLE_ADMIN", user1);
        userRolesRepository.save(userRoles1);

//        UserRoles userRoles2 = new UserRoles("ROLE_USER", user2);
//        userRolesRepository.save(userRoles2);
//
//        UserRoles userRoles3 = new UserRoles("ROLE_USER", user3);
//        userRolesRepository.save(userRoles3);


    }

}