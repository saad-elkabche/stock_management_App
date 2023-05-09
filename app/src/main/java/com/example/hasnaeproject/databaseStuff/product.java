package com.example.hasnaeproject.databaseStuff;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//import org.jetbrains.annotations.NotNull;

@Entity(tableName = "product")
public class product {
    @NonNull
    @PrimaryKey
    String code;
    String ptoductName;
    String categoryName;
    double price;

    public product() {
    }

    public product(@NonNull String code, String ptoductName, String categoryName, double price) {
        this.code = code;
        this.ptoductName = ptoductName;
        this.categoryName = categoryName;
        this.price = price;
    }

    @NonNull
    public String getCode() {
        return code;
    }

    public void setCode(@NonNull String code) {
        this.code = code;
    }

    public String getPtoductName() {
        return ptoductName;
    }

    public void setPtoductName(String ptoductName) {
        this.ptoductName = ptoductName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
