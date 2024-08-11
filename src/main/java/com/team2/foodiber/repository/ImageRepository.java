package com.team2.foodiber.repository;


import com.team2.foodiber.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ImageRepository extends JpaRepository<Image, Long> {
}
