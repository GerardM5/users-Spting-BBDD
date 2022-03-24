package com.example.users;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity(name = "rates")
public class Rate {

    @Id
    private String id = UUID.randomUUID().toString();
    private int rating;
    private String comment;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "video_id")
    private Video video;

    public Rate() {

    }

    public Rate(int rating, String comment) throws Exception {
        checkRate(rating);
        checkComment(comment);
        this.rating = rating;
        this.comment = comment;
    }

    private void checkComment(String comment) throws Exception {
        if (comment.equals("")) throw new Exception("No hay comentario");
    }

    private void checkRate(int rating) throws Exception {
        if (rating > 5 || rating < 1) throw new Exception("Error en la valoración");
    }

    public String getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
