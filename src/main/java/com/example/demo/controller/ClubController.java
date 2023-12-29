package com.example.demo.controller;

import com.example.demo.entity.Club;
import com.example.demo.entity.User;
import com.example.demo.repository.ClubRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller // This means that this class is a Controller
@RequestMapping(path="/club") // This means URL's start with /demo (after Application path)
public class ClubController {


        @Autowired // This means to get the bean called userRepository
// Which is auto-generated by Spring, we will use it to handle the data
        private ClubRepository clubRepository;
        @PostMapping(path="/add") // Map ONLY POST Requests

        public ResponseEntity<Club> addClub(@RequestBody Club club) {
            try {
                Club clubObj = clubRepository.save(club);
                return new ResponseEntity<>(clubObj, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


}
