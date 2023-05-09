package com.example.hasnaeproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hasnaeproject.adapters.categoryAdapter;
import com.example.hasnaeproject.databaseStuff.category;
import com.example.hasnaeproject.databaseStuff.mytools;
import com.example.hasnaeproject.databaseStuff.viewModel;

import java.util.List;

public class viewProductsAct extends AppCompatActivity {
    RecyclerView rc;
    viewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);
        rc=findViewById(R.id.RCcategory);
        categoryAdapter adapter=new categoryAdapter(this,0);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(this));

        mytools tools=new mytools(getApplication());
        List<category> list=tools.getCatgories();
        adapter.setList(list);
    }
}