package com.example.hasnaeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registerAct extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText txtuser,txtPass,txtCofirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sharedPreferences=getSharedPreferences("Myshared",MODE_PRIVATE);
        txtuser=findViewById(R.id.txtuserName);
        txtPass=findViewById(R.id.txtPassw);
        txtCofirm=findViewById(R.id.txtConfirPAss);
    }

    public void registerInfos(View view) {

        String struser=txtuser.getText().toString();
        String strpass=txtPass.getText().toString();
        String strconfirm=txtCofirm.getText().toString();
        if(struser.isEmpty()){
            txtuser.setError("empty");
        }
        else if(strpass.isEmpty()){
            txtPass.setError("empty");
        }
        else if(strconfirm.isEmpty()){
            txtCofirm.setError("empty");
        }
       else if(!strpass.equals(strconfirm)){
            Toast.makeText(this,"password not match",Toast.LENGTH_SHORT).show();
        }
       else{
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.clear();
            editor.putString("user",struser);
            editor.putString("pass",strpass);
            editor.apply();
            Toast.makeText(this,"your data is saved",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,Dashboard.class));
            finish();
       }
    }
}