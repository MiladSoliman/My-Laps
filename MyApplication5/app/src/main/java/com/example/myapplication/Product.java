package com.example.myapplication;

public class Product {
    String title ;
    String description;
    double price ;
    double rating;
    String brand;
    String thumbnail;

    public Product() {
    }

    public Product(String title , String description , double price , double rating , String brand , String thumbnail){
        this.title = title;
        this.description = description ;
        this.price = price;
        this.rating = rating;
        this.brand = brand;
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public double getRating() {
        return rating;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
