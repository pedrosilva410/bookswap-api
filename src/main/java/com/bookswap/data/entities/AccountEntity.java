package com.bookswap.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountEntity {

    @Id
    private String id;
    private String userName;
    private String email;
    private String password;
    private String bio;
    private String contact;

    public AccountEntity(String id, String userName, String email, String password, String bio, String contact) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.contact = contact;
    }

    public AccountEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
