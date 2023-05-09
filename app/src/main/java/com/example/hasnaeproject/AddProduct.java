package com.example.hasnaeproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hasnaeproject.adapters.categoryAdapter;
import com.example.hasnaeproject.databaseStuff.category;
import com.example.hasnaeproject.databaseStuff.mytools;
import com.example.hasnaeproject.databaseStuff.product;

import java.util.List;

public class AddProduct extends AppCompatActivity {
    EditText txtprodname,txtprice,txtcodebar;
    categoryAdapter adapter;
    public android.widget.Button btnChoose;
    String btnChos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        txtprodname=findViewById(R.id.txtproductname);
        txtprice=findViewById(R.id.txtPrice);
        txtcodebar=findViewById(R.id.txtbarprod);
        btnChoose=findViewById(R.id.btnChoose);
        btnChos=btnChoose.getText().toString();
    }

    public void AddCategory(View view) {
        startActivity(new Intent(this,CategoryActivity.class));
    }

    public void scannCode(View view) {
        Intent inten=new Intent(this,scanCode.class);
        startActivityForResult(inten,123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        txtcodebar.setText(data.getStringExtra("result"));
    }

    public void AddProduct(View view) {
        if(TextUtils.isEmpty(txtcodebar.getText())){
            txtcodebar.setError("empty");
        }
        else if(TextUtils.isEmpty(txtprice.getText())){
            txtprice.setError("empty");
        }
       else  if(TextUtils.isEmpty(txtprodname.getText())){
            txtprodname.setError("empty");
        }
       else if(btnChoose.getText().toString().equals(btnChos)){
            Toast.makeText(this, "choose a category", Toast.LENGTH_SHORT).show();
        }
       else{
           mytools tool=new mytools(getApplication());
            product p=tool.getspecifieproduct(txtcodebar.getText().toString());

            if(p==null){
                String category=btnChoose.getText().toString();
                tool.insertProducts(new product(txtcodebar.getText().toString().trim(),txtprodname.getText().toString(),category,Double.parseDouble(txtprice.getText().toString())));
                txtcodebar.setText("");
                txtprice.setText("");
                txtprodname.setText("");
                btnChoose.setText(btnChos);
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "this product is already here", Toast.LENGTH_SHORT).show();
        }

    }

    public void categorylist(View view) {
        AlertDialog dialog;
        AlertDialog.Builder build=new AlertDialog.Builder(this);
         adapter=new categoryAdapter(this,1);

        View v= getLayoutInflater().inflate(R.layout.category_list,null);
        RecyclerView rc=v.findViewById(R.id.RCcategorylist);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(this));
        mytools tool=new mytools(getApplication());
        List<category> list=tool.getCatgories();
        adapter.setList(list);
        build.setView(v);
        dialog=build.create();
        adapter.setDialog(dialog);
        dialog.show();
    }
}