package com.example.retrofit;

import java.util.ArrayList;
import java.util.List;

public class MyResponse {
    private  int total ;
   private   int skip ;
   private  int limit;
   private ArrayList<Proudcts> proudcts;

   public MyResponse (int total , int skip , int limit,ArrayList<Proudcts> proudcts){
       this.total = total;
       this.skip = skip ;
       this.limit = limit;
       this.proudcts = proudcts;
   }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public ArrayList<Proudcts> getProudcts() {
        return proudcts;
    }

    public void setProudcts(ArrayList<Proudcts> proudcts) {
        this.proudcts = proudcts;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
