package com.school.repository;

import com.school.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    public List<User> findByEnabledTrue();

    @Query("select u from User u where u.username like :username and u.id <> :userId ")
    Optional<User> findByUsernameExept(String username, Integer userId);
}
