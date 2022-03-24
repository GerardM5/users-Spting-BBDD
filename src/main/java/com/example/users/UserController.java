package com.example.users;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {



    private UserRepository userRepository;
    private VideoRepository videoRepository;
    private RateRepository rateRepository;

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
        userToModify.setName(newUser.getName());
        userRepository.save(userToModify);
        return userToModify;
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public void deleteAllUsers(){
        userRepository.deleteAll();
    }

    public Video uploadVideo(String userId, Video videoToUpload) {
        User user = getUser(userId);
        videoToUpload = user.addVideo(videoToUpload);
        videoRepository.save(videoToUpload);
        return videoToUpload;
    }


    public List<Video> getVideosOfUser(String userId) {
        List<Video>videoList = new ArrayList<>();
        videoRepository.findAll().forEach(videoList::add);
        return videoList;
    }

    public Video getVideoOfUser(String videoId) {
        //videoRepository.findById(videoId);
        return videoRepository.findById(videoId).get();
    }

    public void deleteVideosOfUser(String userId) {
        videoRepository.deleteAll();
    }
}
