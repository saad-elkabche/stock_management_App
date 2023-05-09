package com.example.hasnaeproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.io.File;

public class firstAct extends AppCompatActivity {

    final  int splashTimeOut=2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
     //  String path=getDatabasePath(databaseList()[0]+".db").getAbsolutePath();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

               // Log.d("hello",path);
                Intent i = new Intent(firstAct.this,loginReg.class);
                startActivity(i);
                finish();
            }

        },splashTimeOut);
    }
}