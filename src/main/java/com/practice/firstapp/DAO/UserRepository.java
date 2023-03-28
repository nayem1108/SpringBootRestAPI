package com.practice.firstapp.DAO;

import org.springframework.data.repository.CrudRepository;

import com.practice.firstapp.Model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    public User findById(int id);
}
