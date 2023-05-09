package com.example.hasnaeproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hasnaeproject.adapters.productAdapter;
import com.example.hasnaeproject.databaseStuff.mytools;
import com.example.hasnaeproject.databaseStuff.product;
import com.example.hasnaeproject.databaseStuff.viewModel;

import java.util.List;

public class DetailesCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailes_category);
        String type=getIntent().getStringExtra("type");
      mytools tool=new mytools(getApplication());
      List<product> lis=tool.getProductsforcombo();
        List<product> list=tool.getProductsOfCategory(type);
        productAdapter adapter=new productAdapter(this);
        adapter.setList(list);
        RecyclerView rc=findViewById(R.id.RCProcuct);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(this));
    }
}