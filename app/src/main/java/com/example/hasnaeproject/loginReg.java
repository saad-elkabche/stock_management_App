package com.example.hasnaeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class loginReg extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    android.widget.Button btnlogin,btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_reg);
        sharedPreferences=getSharedPreferences("Myshared",MODE_PRIVATE);

        btnlogin= findViewById(R.id.btnLog);
        btnRegister= findViewById(R.id.btnReg);

        String struser=sharedPreferences.getString("user","");

        if(struser.equals("")){
            btnlogin.setVisibility(View.INVISIBLE);
        }
        else
            btnRegister.setVisibility(View.INVISIBLE);

    }

    public void login(View view) {
        Intent inte=new Intent(loginReg.this,loginAct.class);
        startActivity(inte);
    }

    public void register(View view) {
        Intent inten=new Intent(loginReg.this,registerAct.class);
        startActivity(inten);
    }
}