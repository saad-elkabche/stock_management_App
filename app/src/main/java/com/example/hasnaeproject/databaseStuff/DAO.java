package com.example.hasnaeproject.databaseStuff;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hasnaeproject.databaseStuff.product;

import java.util.List;
@Dao
public interface DAO {
    //Product
    @Insert
    void InsertProduct(product p);
    @Update
    void updateProduct(product p);
    @Delete
    void DeleteProdut(product p);

    @Query("select * from product where code=:code")
    product getSpiciProduct(String code);
    @Query("select * from product")
    LiveData<List<product>> getAllProducts();

    @Query("select * from product")
    List<product> getAllForComboProducts();

    @Query("select * from product where categoryName=:name")
    List<product> getProductOfCat(String name);

    //Category
    @Insert
    void InsertCategory(category p);
    @Update
    void updateCategory(category p);
    @Delete
    void DeleteCategory(category p);

    @Query("select * from category where categoryName=:code")
    category getSpiciCategory(String code);

    @Query("select * from category")
    LiveData<List<category>> getAllcategory();

    @Query("select * from category")
    List<category> getAllcategoriesTool();

    /*@Query("select * from product")
    LiveData<List<product> getAllForComboProduc();*/


    @Insert
    void Insertpurchase(purchase p);
    @Update
    void updatepurchase(purchase p);
    @Delete
    void Deletepurchase(purchase p);

    @Query("select * from purchase")
    LiveData<List<purchase>> getAllPurchase();

    @Query("select sum(total) from purchase")
    public double getTotal();
}
