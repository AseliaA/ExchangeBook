package com.example.ExchangeBook.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exchange_5")
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;//Creates exchange process
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;//User above wants this book
    @ManyToOne
    @JoinColumn(name = "book_id_ex")
    private Book exchangeFor;//Belongs to the one who created this process
    private LocalDateTime timeCreated;
    private Boolean isCompleted;

    public Exchange() {
    }

    public Exchange(User user, Book book, Book exchangeFor, Boolean isCompleted) {
        this.user = user;
        this.book = book;
        this.exchangeFor = exchangeFor;
        this.timeCreated = LocalDateTime.now();
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getExchangeFor() {
        return exchangeFor;
    }

    public void setExchangeFor(Book exchangeFor) {
        this.exchangeFor = exchangeFor;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
