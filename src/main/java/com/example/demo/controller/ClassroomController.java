package com.example.demo.controller;

import com.example.demo.entity.Classroom;
import com.example.demo.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classrooms") // Adjust the path as needed
public class ClassroomController {

    @Autowired
    private ClassroomRepository classroomRepository;

    @PostMapping("/add")
    public ResponseEntity<Classroom> addClass(@RequestBody Classroom classroom) {
        try {
            Classroom savedClassroom = classroomRepository.save(classroom);
            return new ResponseEntity<>(savedClassroom, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
