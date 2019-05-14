package com.example.ExchangeBook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecureConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/sprint/exchangeBook/Book/getAllBooks",
                        "/sprint/exchangeBook/Book/getBookById",
                "/sprint/exchangeBook/Book/getAllBooksByUserId",
                        "/sprint/exchangeBook/Book/getBookByName",
                        "/sprint/exchangeBook/User/getUserById",
                        "/sprint/exchangeBook/User/getTop100",
                        "/sprint/exchangeBook/User/getUsersAllBooks",
                        "/sprint/exchangeBook/User/deleteUserById",
                        "/sprint/exchangeBook/User/addUser",
                        "/sprint/exchangeBook/Book/addBook",
                        "/sprint/exchangeBook/Book/deleteBookById"
                        ).access("hasRole('USER')")
                /*.antMatchers("/sprint/exchangeBook/Book/getAllBooks",
                        "/sprint/exchangeBook/Book/getBookById",
                        "/sprint/exchangeBook/Book/getAllBooksByUserId",
                        "/sprint/exchangeBook/Book/getBookByName",
                        "/sprint/exchangeBook/User/getUserById",
                        "/sprint/exchangeBook/User/getTop100",
                        "/sprint/exchangeBook/User/getUsersAllBooks",
                        "/sprint/exchangeBook/User/deleteUserById",
                        "/sprint/exchangeBook/User/addUser",
                        "/sprint/exchangeBook/Book/addBook",
                        "/sprint/exchangeBook/Book/deleteBookById",
                        "/sprint/exchangeBook/Book/deleteAllBooks",
                        "/sprint/exchangeBook/User/deleteAllUsers").access("hasRole('ADMIN')")*/
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select login, password, " +
                        "is_active from t_user where login = ?")
                .authoritiesByUsernameQuery("select u.login, " +
                        "ur.role as role " +
                        "from t_user u inner join t_user_roles ur on u.id = ur.user_id " +
                        "where u.login = ?");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

