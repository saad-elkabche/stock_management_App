package com.example.hasnaeproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {
    CardView add,delete,view,purchase;
    TextView txtName;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);



        sharedPreferences=getSharedPreferences("Myshared",MODE_PRIVATE);


        add=findViewById(R.id.addItems);
        delete=findViewById(R.id.deleteItems);
        view=findViewById(R.id.cardviewCategory);
        purchase=findViewById(R.id.cardpurchase);

        txtName=findViewById(R.id.txtNameUSer);
        String str=sharedPreferences.getString("user","");
        txtName.setText("Welcome, "+str);

        add.setOnClickListener((v)-> clickCard(add.getId()));
        delete.setOnClickListener((v)-> clickCard(delete.getId()));
        view.setOnClickListener((v)-> clickCard(view.getId()));
        purchase.setOnClickListener((v)-> clickCard(purchase.getId()));

    }

    private void clickCard(int id) {
        Intent inten;
        switch (id){
            case R.id.addItems:
                inten=new Intent(this,AddProduct.class);
                break;
            case R.id.cardviewCategory:
                inten=new Intent(this,viewProductsAct.class);
                break;
            case R.id.cardpurchase:
                inten=new Intent(this,purchaseAct.class);
                break;
            default:
                inten=new Intent(this,deleteEditPoduct.class);
                break;
        }
        if(inten!=null)
            startActivity(inten);
    }
}