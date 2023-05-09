package com.example.hasnaeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class loginAct extends AppCompatActivity {
    EditText txtUser,txtPass;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUser=findViewById(R.id.txtLogin);
        txtPass=findViewById(R.id.txtPassw);
        sharedPreferences=getSharedPreferences("Myshared",MODE_PRIVATE);
    }

    public void loginCheck(View view) {
        String strUser=txtUser.getText().toString();
        String strPass=txtPass.getText().toString();
        if(strUser.isEmpty()){
            txtUser.setError("empty");
        }
        else if(strPass.isEmpty()){
            txtPass.setError("empty");
        }
        else {
            String ShUser=sharedPreferences.getString("user","");
            String ShPass=sharedPreferences.getString("pass","");
            if(strUser.equals(ShUser)){
                if (strPass.equals(ShPass)){
                    startActivity(new Intent(this,Dashboard.class));
                    finish();
                }
                else Toast.makeText(this, "password incorrect", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(this, "username incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}