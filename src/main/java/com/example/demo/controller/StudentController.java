package com.example.demo.controller;

import com.example.demo.entity.Classroom;
import com.example.demo.entity.Club;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    private ClassroomRepository classroomRepository;
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        try {
            Student studentObj = studentRepository.save(student);
            return new ResponseEntity<>(studentObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Student> getAllStudents() {
// This returns a JSON or XML with the users
        return studentRepository.findAll();
    }
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        try {
            Optional<Student> studentData = studentRepository.findById(id);
            if (studentData.isPresent()) {
                Student updatedStudentData = studentData.get();

                // Update fields
                updatedStudentData.setNsc(student.getNsc());
                updatedStudentData.setEmail(student.getEmail());

                // Update relationships
                updatedStudentData.setClassroom(student.getClassroom());
                updatedStudentData.setClubs(student.getClubs());

                Student studentObj = studentRepository.save(updatedStudentData);
                return new ResponseEntity<>(studentObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteStudentById/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
        try {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            // The record with the given id doesn't exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAllStudents")
    public ResponseEntity<HttpStatus> deleteAllStudents() {
        try {
            studentRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
