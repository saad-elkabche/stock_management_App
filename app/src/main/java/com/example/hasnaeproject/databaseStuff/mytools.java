package com.example.hasnaeproject.databaseStuff;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class mytools {
    DAO myDao;
    public mytools(Application app){
        RoomDb db=RoomDb.getDatabase(app);
        myDao= db.myDAO();
    }
    //product
    public void insertProducts(product p){
        myDao.InsertProduct(p);
    }
    public void deleteProducts(product p){
        myDao.DeleteProdut(p);
    }
    public void updateProducts(product p){
        myDao.updateProduct(p);
    }


    //category
    public void insertcategory(category c){
        myDao.InsertCategory(c);
    }
    public void deletecategory(category c){
        myDao.DeleteCategory(c);
    }
    public void updatecategory(category c){
        myDao.updateCategory(c);
    }



    //purchase
    public void insertpurchase(purchase c){
        myDao.Insertpurchase(c);
    }
    public void deletepurchase(purchase c){
        myDao.Deletepurchase(c);
    }
    public void updatepurchase(purchase c){
        myDao.updatepurchase(c);
    }

    public List<category> getCatgories(){
        return myDao.getAllcategoriesTool();
    }

    public LiveData<List<purchase>> getPurchases(){
        return myDao.getAllPurchase();
    }


    public category getspecifieCat(String name){
        return myDao.getSpiciCategory(name);
    }
    public product getspecifieproduct(String code){
        return myDao.getSpiciProduct(code);
    }


    public LiveData<List<product>> getLiveProduct(){
        return myDao.getAllProducts();
    }
    public List<product> getProductsforcombo(){
        return myDao.getAllForComboProducts();
    }

    public LiveData<List<category>> getcategories(){
        return myDao.getAllcategory();
    }
    public List<product> getProductsOfCategory(String name){
        return myDao.getProductOfCat(name);
    }

    public double getTotal(){
        return myDao.getTotal();
    }
}
