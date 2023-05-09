package com.example.hasnaeproject.databaseStuff;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {product.class,category.class,purchase.class},version = 1,exportSchema = false)
public abstract class RoomDb extends RoomDatabase {
    public abstract DAO myDAO();

    static RoomDb mydb;

    public static RoomDb getDatabase(final Context context){
        if(mydb==null){
            synchronized (RoomDb.class){
                if(mydb==null){
                    mydb = Room.databaseBuilder(context.getApplicationContext(), RoomDb.class, "mydatabase")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return mydb;
    }
}
