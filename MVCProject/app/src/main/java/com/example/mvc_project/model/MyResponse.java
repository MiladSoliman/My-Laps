package com.example.mvc_project.model;

import java.util.ArrayList;

public class MyResponse {
    private String total ;
    private  String skip ;
    private  String limit;
    private ArrayList<Product> products ;

    public MyResponse(String total, String skip, String limit, ArrayList<Product> products) {
        this.total = total;
        this.skip = skip;
        this.limit = limit;
        this.products = products;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
