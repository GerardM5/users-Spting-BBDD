package com.example.users;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "videos")
public class Video {
    private static final int MIN_CHARACTERS_TITLE = 10;
    @Id
    private String id = UUID.randomUUID().toString();
    private String url;
    private String title;
    private String description;

    @OneToMany(mappedBy = "video")
    private List<Rate> rateList = new ArrayList<>();

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "video_id")
    private User user;


    public Video() {

    }

    public Video(String url, String title, String description, User user) throws Exception {
        checkUrl(url);
        checkTitle(title);
        this.url = url;
        this.title = title;
        this.description = description;
        this.user = user;
    }


    private void checkTitle(String title) throws Exception {
        if (url.length() < MIN_CHARACTERS_TITLE) throw new Exception("Titulo muy corto");
    }

    private void checkUrl(String url) throws Exception {
        if (!url.contains("www.")) throw new Exception("No es una URL valida");
    }

    public void setUser(User user) {
        this.user=user;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setUrl(String url) throws Exception {
        checkUrl(url);
        this.url = url;
    }

    public void setTitle(String title) throws Exception {
        checkTitle(title);
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rate rateVideo(Rate rating) {
        rateList.add(rating);
        return rating;
    }



    public List<Rate> getRateList() {
        return rateList;
    }

}
