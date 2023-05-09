package com.example.hasnaeproject.databaseStuff;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;



@Entity(tableName = "category")
public class category {
   @NonNull
    @PrimaryKey
    String categoryName;
    @ColumnInfo(typeAffinity= ColumnInfo.BLOB)
    byte[] img;

    public category(@NonNull String categoryName, byte[] img) {
        this.categoryName = categoryName;
        this.img = img;
    }

    public category() {
    }

    @NonNull
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(@NonNull String categoryName) {
        this.categoryName = categoryName;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
