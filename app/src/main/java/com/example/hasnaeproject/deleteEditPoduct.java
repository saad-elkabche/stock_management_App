package com.example.hasnaeproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hasnaeproject.databaseStuff.mytools;
import com.example.hasnaeproject.databaseStuff.product;

public class deleteEditPoduct extends AppCompatActivity {
    EditText txtcodebar;
    TextView txtProdName,txtProdPrice;
    CardView card;
    String code;
    com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_edit_poduct);
        txtcodebar=findViewById(R.id.txtCodeProd);
        txtProdName=findViewById(R.id.txtprodName);
        txtProdPrice=findViewById(R.id.txtprodprice);
        card=findViewById(R.id.cardInfo);
        floatingActionButton=findViewById(R.id.floatingActionButton);
    }

    public void deleteProduct(View view) {
        if(code!=null || code!=""){
            product p=new product(code,"","",0);
            mytools mtool=new mytools(getApplication());
            mtool.deleteProducts(p);
            card.setVisibility(View.INVISIBLE);
            floatingActionButton.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
        }
        else {

        }

    }

    public void scanco(View view) {
        Intent inten=new Intent(this,scanCode.class);
        startActivityForResult(inten,123);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        txtcodebar.setText(data.getStringExtra("result"));
        mytools tool=new mytools(getApplication());
        product p=tool.getspecifieproduct(txtcodebar.getText().toString());
        if(p!=null) {
            code=txtcodebar.getText().toString();
            card.setVisibility(View.VISIBLE);
            floatingActionButton.setVisibility(View.VISIBLE);
            txtProdName.setText(p.getPtoductName());
            txtProdPrice.setText(Double.toString(p.getPrice()));
        }else{
            card.setVisibility(View.INVISIBLE);
            floatingActionButton.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "this product not exist", Toast.LENGTH_SHORT).show();
        }
    }
}