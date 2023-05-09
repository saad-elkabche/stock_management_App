package com.example.hasnaeproject;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hasnaeproject.databaseStuff.category;
import com.example.hasnaeproject.databaseStuff.mytools;

import java.io.ByteArrayOutputStream;

public class CategoryActivity extends AppCompatActivity {
    ImageView imgcategory;
    EditText txtcategoryName;
    String Path="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        imgcategory=findViewById(R.id.imgCatgory);
        txtcategoryName=findViewById(R.id.txtcategoryname);
    }

    public void addcategory(View view) {
        if(Path.isEmpty()){
            Toast.makeText(this, "choose Image", Toast.LENGTH_SHORT).show();
        }
        else if(txtcategoryName.getText().toString().isEmpty()){
            txtcategoryName.setError("empty");
        }
        else {
            mytools tool= new mytools(getApplication());
            category cat=tool.getspecifieCat(txtcategoryName.getText().toString());
            if(cat==null){
                Bitmap bitmap =((BitmapDrawable)imgcategory.getDrawable()).getBitmap();
                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
                byte[] bytes=stream.toByteArray();
                tool.insertcategory(new category(txtcategoryName.getText().toString().trim(),bytes));
                Path="";
                txtcategoryName.setText("");
                imgcategory.setImageResource(R.drawable.logo);
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "this category is already here", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void pickImage(View view) {
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
       startActivityForResult(intent,123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==123&&resultCode==RESULT_OK){
            Path=data.getData().toString();
            imgcategory.setImageURI(data.getData());
        }
    }
    
}