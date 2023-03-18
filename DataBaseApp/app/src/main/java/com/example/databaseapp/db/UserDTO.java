package com.example.databaseapp.db;

public class UserDTO {
private String userName;
private  String phone;


    public UserDTO(String userName, String phone) {
        this.userName = userName;
        this.phone = phone;
    }
    public UserDTO() {
    }

    public String getPhone() {
        return phone;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}

