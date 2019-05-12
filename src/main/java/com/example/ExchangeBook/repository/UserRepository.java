package com.example.ExchangeBook.repository;

import com.example.ExchangeBook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "select from book_user order by raiting asc")
    Integer getRaitingOfGenerosity;
}
