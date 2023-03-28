package com.practice.firstapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.firstapp.Model.User;
import com.practice.firstapp.Service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService USER_SERVICE;

    @GetMapping("/users")
    public List<User> getUsers(){
        return this.USER_SERVICE.getUsers();
    }

    @PostMapping("/users/create-user")
    public User createUser(@RequestBody User user){
        this.USER_SERVICE.createUser(user);
        return user;
    }

    @PutMapping("users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") int id){

        User update_user = this.USER_SERVICE.updatUser(user, id);
        return update_user;
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable("id") int id){
        return this.USER_SERVICE.deleteUserById(id);
    }
}

