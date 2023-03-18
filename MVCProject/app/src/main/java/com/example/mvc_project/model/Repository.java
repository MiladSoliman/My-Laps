package com.example.mvc_project.model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.mvc_project.db.AppDataBase;
import com.example.mvc_project.db.ProductDAO;

import java.util.List;

public class Repository {
    private Context context ;
    private ProductDAO productDAO ;
    private LiveData<List<Product>> storedProducts;

    private  static  Repository repository =null;

    Product product;

    private Repository (Context context){
        this.context = context;
        AppDataBase appDataBase = AppDataBase.getInstance(context.getApplicationContext());
        productDAO = appDataBase.productDAO();
        storedProducts = productDAO.getFavProducts();

    }

    public static Repository getInstance(Context context){
        if(repository == null){
            repository = new Repository(context);
        }

        return repository;
    }


    public LiveData<List<Product>> getFavProducts(){
        return storedProducts;
    };

    public void delete(Product product){
        new Thread(new Runnable() {
            @Override
            public void run() {
             productDAO.deleteMovie(product);
            }
        }).start();

    }

    public void insert(Product product){
        new Thread(new Runnable() {
            @Override
            public void run() {
                productDAO.insertProduct(product);
            }
        }).start();
    }


}
