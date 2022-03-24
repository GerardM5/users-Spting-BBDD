package com.example.users;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/videos/")
public class VideoRestController {

    private UserController userController;

    public VideoRestController(UserController userController) {
        this.userController = this.userController;
    }


    @PostMapping
    public Video uploadVideo(@PathVariable String userId, @RequestBody Video videoToUpload) throws Exception {
        return userController.uploadVideo(userId, videoToUpload);
    }

    @GetMapping
    public List<Video> getVideosOfUser(@PathVariable String userId) throws Exception {
        return userController.getVideosOfUser(userId);
    }

    @GetMapping("{videoId}")
    public Video getVideoOfUser(@PathVariable String userId, @PathVariable String videoId) throws Exception {
        return userController.getVideoOfUser(videoId);
    }

    @DeleteMapping
    public void deleteVideosOfUser(@PathVariable String userId) throws Exception {
        userController.deleteVideosOfUser(userId);
    }
//
//    @PostMapping("{videoId}")
//    public Rating rateVideo(@PathVariable String userId,@PathVariable String videoId,@RequestBody Rating rating) throws Exception {
//        return userController.rateVideo(userId,videoId,rating);
//    }



}
