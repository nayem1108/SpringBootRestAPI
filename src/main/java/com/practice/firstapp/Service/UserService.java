package com.practice.firstapp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.firstapp.DAO.UserRepository;
import com.practice.firstapp.Model.User;

@Component
public class UserService {

    @Autowired
    private UserRepository USER_REPOSITORY;
    
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users = (List<User>)this.USER_REPOSITORY.findAll();
        return users;
    }

    public void createUser(User user){
        this.USER_REPOSITORY.save(user);
    }

    public User updatUser(User user, int id){

        User curr_user = this.USER_REPOSITORY.findById(id);

        if(curr_user != null){
            curr_user.setName(user.getName());
            curr_user.setEmail(user.getEmail());
            curr_user.setPassword(user.getPassword());
            this.USER_REPOSITORY.save(curr_user);
        }

        return curr_user;
    }

    public User deleteUserById(int id){
        User user = this.USER_REPOSITORY.findById(id);

        if(user != null){
            this.USER_REPOSITORY.deleteById(id);
        }
        return user;

    }
    
}
