package com.example.ExchangeBook.model;

import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "book_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "login",nullable = false,unique = true)
    private String login;
    @Column(name = "password",nullable = false,unique = true)
    private String password;
    @Column(name = "is_active",nullable = false)
    private int isActive;
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;
    @OneToMany
    @JoinColumn(name = "book_id")
    private List<Book>book;
    @Column(name = "rating")
    private int raitingOfGenerosity;

    public User() {
    }

    public User(String name, String login, String password, int isActive, String phoneNumber) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.isActive = isActive;
        this.phoneNumber = phoneNumber;
    }
}
