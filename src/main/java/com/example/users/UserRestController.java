package com.example.users;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private UserController userController;

    public UserRestController(UserController userController) {
        this.userController = userController;
    }


    @PostMapping
    public User createUser(@RequestBody User userToCreate){

        return userController.createUser(userToCreate);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody User newUser){
        return userController.updateUser(userId, newUser);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userController.getAllUsers();
    }

    /*@GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return userController.findUser(id);
    }*/
    @DeleteMapping
    public void deleteAllUsers(){
        userController.deleteAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userController.deleteUser(id);
    }



}
