package com.example.hasnaeproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hasnaeproject.AddProduct;
import com.example.hasnaeproject.DetailesCategory;
import com.example.hasnaeproject.R;
import com.example.hasnaeproject.databaseStuff.category;
import com.example.hasnaeproject.databaseStuff.product;

import java.util.ArrayList;
import java.util.List;

public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.VH> {
    Context context;
    List<category> list;
    AlertDialog dialog;
    AddProduct activiryadd;
    public void setDialog(AlertDialog dialog) {
        this.dialog = dialog;
    }

   /* int check=0;

    public void setCheck(int check) {
        this.check = check;
    }*/

    public void setList(List<category> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public categoryAdapter(Context context,int type) {
        this.context = context;
        if(type!=0)
            activiryadd=(AddProduct)context;
    }

    @NonNull
    @Override
    public categoryAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryAdapter.VH holder, int position) {
        if(list!=null){
            byte[]bytes =list.get(position).getImg();
            Bitmap bitm= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
            holder.img.setImageBitmap(bitm);
            holder.txt.setText(list.get(position).getCategoryName());
        }

    }

    @Override
    public int getItemCount() {
        if(list!=null)
            return  list.size();
        return 0;

    }

    public class VH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        public VH(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txtCatName);
            img=itemView.findViewById(R.id.imgCat);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(dialog!=null){
                        activiryadd.btnChoose.setText(txt.getText());
                        dialog.dismiss();
                    }
                    else {
                        Intent intent=new Intent(context, DetailesCategory.class);
                        intent.putExtra("type",txt.getText().toString());
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
