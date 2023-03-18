package com.example.mvc_project.allproducts.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvc_project.R;
import com.example.mvc_project.allproducts.view.allAdabter;
import com.example.mvc_project.allproducts.view.onAdd;
import com.example.mvc_project.model.Product;
import com.example.mvc_project.model.Repository;
import com.example.mvc_project.network.NetworkDelegate;
import com.example.mvc_project.network.Product_Client;

import java.util.ArrayList;

public class AllProductsActivity extends AppCompatActivity implements NetworkDelegate , onAdd {

    RecyclerView recyclerView ;
    com.example.mvc_project.allproducts.view.allAdabter allAdabter;
    RecyclerView.LayoutManager layoutManager;
    Product_Client product_client ;

    onAdd onadd;

    Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
        recyclerView = findViewById(R.id.recycler_view);
        product_client =Product_Client.getInstance();
        product_client.enqueueCall(this);
        layoutManager = new LinearLayoutManager(this);
        repo = Repository.getInstance(this);

    }

    @Override
    public void onSuccessResponse(ArrayList<Product> products) {
        allAdabter = new allAdabter(this,products , this);
        recyclerView.setAdapter(allAdabter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onFailureResponse(String error) {

    }

    @Override
    public void onClick(Product product) {
            repo.insert(product);
            Toast.makeText(AllProductsActivity.this, "Added To Favourite", Toast.LENGTH_SHORT).show();
        }
    }
