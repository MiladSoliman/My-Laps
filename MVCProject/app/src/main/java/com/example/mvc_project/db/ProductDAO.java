package com.example.mvc_project.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvc_project.model.Product;

import java.util.List;

@Dao
public interface ProductDAO {
    @Query("SELECT * From products")
    LiveData<List<Product>> getFavProducts();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertProduct(Product product);
    @Delete
    void deleteMovie (Product product);
}
