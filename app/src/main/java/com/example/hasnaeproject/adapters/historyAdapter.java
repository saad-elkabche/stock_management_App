package com.example.hasnaeproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hasnaeproject.R;
import com.example.hasnaeproject.databaseStuff.purchase;

import java.util.ArrayList;
import java.util.List;

public class historyAdapter extends RecyclerView.Adapter<historyAdapter.VH> {
    Context cont;
    List<purchase> list;

    public void setList(List<purchase> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public historyAdapter(Context cont) {
        this.cont = cont;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(cont).inflate(R.layout.item_history, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        if(list!=null) {
            holder.txtnameProd.setText(list.get(position).getProductName());
            holder.txtpriceProd.setText(Double.toString(list.get(position).getProductPrice()) +" DH");
            holder.txtQuantity.setText( "Quantiti : "+ Integer.toString(list.get(position).getQuantiti()));
            holder.txtTotal.setText("Total : "+Double.toString(list.get(position).getTotal())+" DH");
            holder.txtTime.setText(list.get(position).getDate());
        }
    }

    @Override
    public int getItemCount() {
        if(list!=null)
            return list.size();
        return 0;
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView txtpriceProd,txtQuantity,txtTotal,txtnameProd,txtTime;

        public VH(@NonNull View itemView) {
           super(itemView);
            txtnameProd=itemView.findViewById(R.id.txtprodName);
            txtpriceProd=itemView.findViewById(R.id.txtprodprice);
            txtQuantity=itemView.findViewById(R.id.txtprodQuantiti);
            txtTotal=itemView.findViewById(R.id.txttotal);
            txtTime=itemView.findViewById(R.id.txtDate);
        }
    }
}
