package com.example.users;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {



    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User createUser(User userToCreate){
        userRepository.save(userToCreate);
        return userToCreate;
    }

    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }


    public User getUser(String userId) {
        return userRepository.findById(userId).get();
    }


    public User updateUser(String userId, User newUser){
        User userToModify = getUser(userId);
        userToModify.setEmail(newUser.getEmail());
        userToModify.setPassword(newUser.getPassword());
        userToModify.setGender(newUser.getGender());
        userRepository.save(userToModify);
        return userToModify;
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }

}
