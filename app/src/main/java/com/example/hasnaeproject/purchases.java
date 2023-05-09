package com.example.hasnaeproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hasnaeproject.databaseStuff.category;
import com.example.hasnaeproject.databaseStuff.mytools;
import com.example.hasnaeproject.databaseStuff.product;
import com.example.hasnaeproject.databaseStuff.purchase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class purchases extends Fragment {
    EditText txtCode;
    CardView cardView;
    ImageView img;
    TextView txtCatna,txtProdName,txtprice,txttotal,txtquantiti;
    int Count=1;
    double price,total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_purchases, container, false);


        ImageButton btn=v.findViewById(R.id.btnScanPur);
        txtCode=v.findViewById(R.id.txtCodeProd);
        cardView=v.findViewById(R.id.cardInfo);
        txtCatna=v.findViewById(R.id.txtCategoryName);
        txtProdName=v.findViewById(R.id.txtprodName);
        txtprice=v.findViewById(R.id.txtprodprice);
        txtquantiti=v.findViewById(R.id.txtQuantiti);
        txttotal=v.findViewById(R.id.txttotal);
        img=v.findViewById(R.id.imgCatgory);

        Button btnConfirm=v.findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mytools tool=new mytools(getActivity().getApplication());
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd-hh:mm");
                Calendar cal=Calendar.getInstance();
                String time =simpleDateFormat.format(cal.getTime());
                purchase pur=new purchase(txtProdName.getText().toString(),price,Count,total,time);
                tool.insertpurchase(pur);
                Toast.makeText(getContext(), "Success Added", Toast.LENGTH_SHORT).show();
                cardView.setVisibility(View.INVISIBLE);
                double tot=tool.getTotal();
                purchaseAct.saisieTot(tot);
            }
        });

        Button btnAdd=v.findViewById(R.id.btnAdd);
        Button btnMoi=v.findViewById(R.id.btnmoin);
        btnAdd.setOnClickListener((vie)->quantity(0));
        btnMoi.setOnClickListener((vie)->quantity(1));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),scanCode.class);
                startActivityForResult(intent,123);
            }
        });
        return v;
    }

    private void quantity(int oper) {
        if(oper==0){
            Count++;
            txtquantiti.setTextColor(Color.parseColor("#058857"));
            txtquantiti.setText(Integer.toString(Count));

        }
        else {
            if(Count>1){
               Count--;
                txtquantiti.setTextColor(Color.parseColor("#E13C30"));
                txtquantiti.setText(Integer.toString(Count));
            }
        }
        total=price*Count;
        txttotal.setText(Double.toString(total));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        txtCode.setText(data.getStringExtra("result"));
        getProduct();
    }

    private void getProduct() {
        mytools tool=new mytools(getActivity().getApplication());
        product p=tool.getspecifieproduct(txtCode.getText().toString());
        if(p!=null){
            List<product> list=tool.getProductsforcombo();
            cardView.setVisibility(View.VISIBLE);
            category cat=tool.getspecifieCat(p.getCategoryName());
            byte[] bytes=cat.getImg();
            Bitmap bitm= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
            img.setImageBitmap(bitm);
            txtCatna.setText(p.getCategoryName());
            price=p.getPrice();
            total=price;
            txtprice.setText(Double.toString(p.getPrice())+" DH");
            txttotal.setText(Double.toString(p.getPrice())+" DH");
            txtProdName.setText(p.getPtoductName());
        }
        else {
            cardView.setVisibility(View.INVISIBLE);
            Toast.makeText(getContext(), "this product not exist", Toast.LENGTH_SHORT).show();
        }
    }
}