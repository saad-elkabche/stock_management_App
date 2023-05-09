package com.example.hasnaeproject.databaseStuff;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//import org.jetbrains.annotations.NotNull;

@Entity
public class purchase {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    int id;
    String productName;
    double ProductPrice;
    int quantiti;
    double total;
    String date;

    public purchase() {
    }

    public purchase( String productName, double productPrice, int quantiti, double total, String date) {

        this.productName = productName;
        ProductPrice = productPrice;
        this.quantiti = quantiti;
        this.total = total;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    public int getQuantiti() {
        return quantiti;
    }

    public void setQuantiti(int quantiti) {
        this.quantiti = quantiti;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
