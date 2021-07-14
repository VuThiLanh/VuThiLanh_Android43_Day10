package com.example.webapi_demo;

public class Product {
    int id;
    String title;
    int status;
    int publisherID;


    public Product(int id, String title, int status, int publisherID) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.publisherID = publisherID;
    }

    public Product(int id, int publisherID, String title) {
        this.id = id;
        this.title = title;
        this.publisherID = publisherID;
    }

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
