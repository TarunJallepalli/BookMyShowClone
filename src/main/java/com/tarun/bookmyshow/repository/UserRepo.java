package com.tarun.bookmyshow.repository;

import com.tarun.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    public Optional<User> getUserById(Integer userId);
}
