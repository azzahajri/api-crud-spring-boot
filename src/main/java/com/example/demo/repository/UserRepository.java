package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    //List<User> findAllByLastName (String lastName);

    @Query("from User u where u.name=:categoryName")
    public List<User> findAllByLastName(String categoryName);

    @Query("from User u where u. id =:id")
    User findById(int id);

}