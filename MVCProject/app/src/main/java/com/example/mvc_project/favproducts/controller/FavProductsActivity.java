package com.example.mvc_project.favproducts.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvc_project.R;
import com.example.mvc_project.favproducts.view.favAdabter;
import com.example.mvc_project.favproducts.view.onRemove;
import com.example.mvc_project.model.Product;
import com.example.mvc_project.model.Repository;

import java.util.ArrayList;
import java.util.List;

public class FavProductsActivity extends AppCompatActivity implements onRemove {
    RecyclerView favRecyclerView ;
    favAdabter favadbter ;
    Repository repo ;
    RecyclerView.LayoutManager layoutManager ;
    List<Product> updatedProducts ;
    onRemove onremove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_products);
        favRecyclerView = findViewById(R.id.fav_recyclerView);
        repo = Repository.getInstance(this);
        repo.getFavProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                favadbter = new favAdabter(FavProductsActivity.this, new ArrayList<>(),FavProductsActivity.this);
                layoutManager = new LinearLayoutManager(FavProductsActivity.this);
                favRecyclerView.setLayoutManager(layoutManager);
                favRecyclerView.setAdapter(favadbter);
                favadbter.setList(products);
                favadbter.notifyDataSetChanged();

            }
        });

    }

    @Override
    public void onDelete(Product product) {
       repo.delete(product);
       repo.getFavProducts().observe(this, new Observer<List<Product>>() {
           @Override
           public void onChanged(List<Product> products) {
               favadbter.setList(products);
               favadbter.notifyDataSetChanged();
           }
       });

       Toast.makeText(FavProductsActivity.this, "Removed Item TO Favourite", Toast.LENGTH_SHORT).show();

    }
}