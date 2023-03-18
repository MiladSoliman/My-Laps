package com.example.myapplication;

import java.util.ArrayList;

public class MyResponse {
    private  String total ;
    private  String skip ;
    private  String limit;
    private ArrayList<Product> proudcts= new ArrayList<>();

    public MyResponse (String total , String skip , String limit,ArrayList<Product> proudcts){
        this.total = total;
        this.skip = skip ;
        this.limit = limit;
        this.proudcts = proudcts;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public ArrayList<Product> getProudcts() {
        return proudcts;
    }

    public void setProudcts(ArrayList<Product> proudcts) {
        this.proudcts = proudcts;
    }

    public String getSkip() {
        return skip;
    }

    public void setSkip(String skip) {
        this.skip = skip;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
