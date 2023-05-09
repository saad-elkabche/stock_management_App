package com.example.hasnaeproject.databaseStuff;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class viewModel extends AndroidViewModel {
    mytools mytool;
    public viewModel(@NonNull Application application) {
        super(application);
        mytool=new mytools(application);
    }

    public LiveData<List<product>> getProducts(){
        return mytool.getLiveProduct();
    }

    public LiveData<List<category>> getCategory(){
        return mytool.getcategories();
    }

    public LiveData<List<purchase>> getPurchase(){return mytool.getPurchases();}
}
