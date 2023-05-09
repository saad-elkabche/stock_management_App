package com.example.hasnaeproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
/*import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;*/

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ScanMode;
import com.google.zxing.Result;



public class scanCode extends AppCompatActivity   {

    CodeScanner codescanner;
    CodeScannerView scannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);
        scannerView=findViewById(R.id.scanner_view);

        codescanner=new CodeScanner(this,scannerView);

        codescanner.setAutoFocusEnabled(true);
        codescanner.setFormats(CodeScanner.ALL_FORMATS);
        codescanner.setScanMode(ScanMode.CONTINUOUS);
        codescanner.setCamera(CodeScanner.CAMERA_BACK);

        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                codescanner.startPreview();
            }
        });
        codescanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                Intent inten=new Intent();
                inten.putExtra("result",result.getText());
                setResult(12,inten);
                finish();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        codescanner.startPreview();
    }

    @Override
    public void onBackPressed() {
        codescanner.releaseResources();
       finish();
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        codescanner.releaseResources();
        super.onPause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                    0);
        }

    }
}