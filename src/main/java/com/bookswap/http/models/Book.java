package com.bookswap.http.models;

public class Book {
    private String id;
    private String title;
    private String description;
    private String location;
    private String genres;
    private String image;
    private String user;

    public Book(String id, String title, String description, String location, String genres, String image, String user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.genres = genres;
        this.image = image;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
