package com.example.ExchangeBook.repository;

import com.example.ExchangeBook.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends
        JpaRepository<UserRoles,Integer> {
}
