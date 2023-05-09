package com.example.hasnaeproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.example.hasnaeproject.adapters.fragementAdapter;
import com.example.hasnaeproject.databaseStuff.mytools;
import com.google.android.material.tabs.TabLayout;

public class purchaseAct extends AppCompatActivity {
    public static TextView txtTot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        TabLayout tab=findViewById(R.id.tablyout);
        ViewPager pager=findViewById(R.id.pager);
        tab.setupWithViewPager(pager);
        pager.setAdapter(new fragementAdapter(getSupportFragmentManager(),tab.getTabCount()));
        mytools tool=new mytools(getApplication());


        txtTot=findViewById(R.id.total);
        double d=tool.getTotal();
        saisieTot(d);
    }

    public static void saisieTot(Double d){

        txtTot.setText(Double.toString(d)+" DH");
    }
}