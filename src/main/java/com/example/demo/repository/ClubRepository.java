package com.example.demo.repository;

import com.example.demo.entity.Club;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
