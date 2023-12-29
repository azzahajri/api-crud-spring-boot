package com.example.demo.repository;


import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {


    @Query("from Student u where u.nsc=:categoryNsc")
    public List<Student> findAllByLastName(Integer categoryNsc);

    @Query("from Student u where u.nsc =:nsc")
    Student findById(int nsc);

}
