package com.example.mvc_project.network;

import com.example.mvc_project.model.MyResponse;
import com.example.mvc_project.model.Product;

import java.util.ArrayList;

import retrofit2.Response;

public interface NetworkDelegate {
    public void onSuccessResponse(ArrayList<Product> products);
    public void onFailureResponse (String error);
}
