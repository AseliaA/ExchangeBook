package com.example.ExchangeBook.repository;

import com.example.ExchangeBook.model.Book;
import com.example.ExchangeBook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select u from User u order by u.ratingOfGenerosity asc")
    List<User> getRatingOfGenerosity();

    @Query(value = "select u.book from User u where u.id = :userId")
    List<Book>getBook(@Param(":userId")Long UserId);
}
