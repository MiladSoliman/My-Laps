package com.example.mvc_project.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product {
    @ColumnInfo (name = "title")
    private String title ;
    @ColumnInfo (name = "price")
    private  int price ;
    @PrimaryKey
    @ColumnInfo (name = "descriptin")
    @NonNull
    private  String description ;
    @ColumnInfo (name = "image_url")
    private String thumbnail ;
    @ColumnInfo (name = "brand")
    private String brand ;

    public Product(String title, int price, String description, String thumbnail, String brand) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
