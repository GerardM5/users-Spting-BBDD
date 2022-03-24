package com.example.users;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "users")
public class    User {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Video> videoList = new ArrayList<>();

    public User() {

    }

    public User(String email, String password, String name) throws Exception {
        checkName(name);
        checkEmail(email);
        checkPassword(password);
        this.email = email;
        this.password = password;
        this.name = name;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    public Video addVideo(Video video) {
        video.setUser(this);
        this.videoList.add(video);
        return video;
    }

    private void checkName(String name) throws Exception {
        if (!name.trim().matches("^[A-Za-z0-9]{5,20}$"))
            throw new Exception("El nom d'usuari ha de tenir entre 5 i 20 caràcters i ha d'estar format per caràcters alfanumèrics");
    }

    private void checkEmail(String email) throws Exception {
        if (!email.trim().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"))
            throw new Exception("El correu electrònic té caràcters no acceptats");
    }

    private void checkPassword(String password) throws Exception {
        if (!password.trim().matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{7,}$"))
            throw new Exception("La contrassenya ha de tenir mínim 7 caràcters, mínim un número i mínim una lletra");
    }

}
