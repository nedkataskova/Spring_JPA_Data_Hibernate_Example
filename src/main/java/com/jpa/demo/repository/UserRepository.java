package com.jpa.demo.repository;

import com.jpa.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User  findByEmailAddress(String email);
    List< User > findByLastname(String lastname);
}
