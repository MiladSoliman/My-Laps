package com.example.versionofmobiles;

public class Products {
    String title ;
    String decription;
    double price ;
    double rating;
    String brand;
    String thumbnail;

    public Products() {
    }

    public Products (String title , String decription , double price , double rating , String brand , String thumbnail){
        this.title = title;
        this.decription = decription ;
        this.price = price;
        this.rating = rating;
        this.brand = brand;
        this.thumbnail = thumbnail;
    }

    public String getDecription() {
        return decription;
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

    public void setDecription(String decription) {
        this.decription = decription;
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
