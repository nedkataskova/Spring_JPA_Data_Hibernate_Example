package com.jpa.demo.repository;

import com.jpa.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User  findByEmailAddress(String email);
    List<User> findByLastname(String lastname);

    @Query(value = "SELECT * FROM USERS WHERE AGE > ?1 AND AGE < ?2" , nativeQuery = true)
    List<User> findUsersBetweenAges(int minAge, int maxAge);
}
