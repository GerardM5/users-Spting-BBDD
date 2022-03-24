package com.example.users;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {



    private UserRepository userRepository;
    private VideoRepository videoRepository;
    private RateRepository rateRepository;

    public UserController(UserRepository userRepository, VideoRepository videoRepository, RateRepository rateRepository) {
        this.userRepository = userRepository;
        this.videoRepository = videoRepository;
        this.rateRepository = rateRepository;
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


    private User findUser(String userId) {
        return userRepository.findById(userId).get();
    }


    public User updateUser(String userId, User newUser){
        User userToModify = findUser(userId);
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

    public Video addVideo(String userId, Video video) {
        User user = findUser(userId);
        video = user.addVideo(video);
        videoRepository.save(video);
        return video;
    }


    public List<Video> getVideosOfUser(String userId) {
        User user = findUser(userId);
        return user.getVideoList();
    }

    public Video getVideoOfUser(String videoId) {
        return videoRepository.findById(videoId).get();
    }
    public void deleteUserVideos(String userId) throws Exception {
        User user = findUser(userId);
        videoRepository.deleteAllByUser(user);
    }
    public void deleteVideosOfUser(String userId) {
        videoRepository.deleteAll();
    }
/*
    public void rateVideo(String userId, String videoId, Rate rate) throws Exception {
        Video video = getVideo(userId, videoId);
        video.addRate(rate);
        rateRepository.save(rate);
    }*/
}
