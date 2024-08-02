package com.team2.foodiber.repository;

import com.team2.foodiber.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
