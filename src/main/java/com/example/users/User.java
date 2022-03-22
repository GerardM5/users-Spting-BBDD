package com.example.users;




import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class User {

    @Id
    private String id;
    private String email;
    private String password;
    private int gender;

    private static final int MALE = 1;
    private static final int FEMALE = 2;



    public User(){
        this.id = UUID.randomUUID().toString();
    }

    public User(String email, String password, int gender) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
        this.gender = gender;


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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
