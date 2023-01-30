package com.example.b_thames.model;

public class shorts_model {
    String url,message,name,rating;

    public shorts_model(String url, String message, String name, String rating) {
        this.url = url;
        this.message = message;
        this.name = name;
        this.rating = rating;
    }

    public shorts_model() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
