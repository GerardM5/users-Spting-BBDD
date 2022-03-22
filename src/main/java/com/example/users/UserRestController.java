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
    public User createUser(@RequestBody User userToCreate) throws Exception {

        return userController.createUser(userToCreate);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody User newUser) throws Exception {
        return userController.updateUser(userId, newUser);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userController.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) throws Exception {
        return userController.getUser(id);
    }
    @DeleteMapping
    public void deleteAllUsers(){
        userController.deleteAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) throws Exception {
        userController.deleteUser(id);
    }



}
