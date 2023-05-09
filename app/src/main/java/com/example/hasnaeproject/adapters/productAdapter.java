package com.example.hasnaeproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hasnaeproject.R;
import com.example.hasnaeproject.databaseStuff.product;

import java.util.List;

public class productAdapter extends RecyclerView.Adapter<productAdapter.VH> {
    List<product> list;
    Context context;

    public void setList(List<product> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public productAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public productAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);

        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull productAdapter.VH holder, int position) {
        if(list!=null){
            holder.txtNameProde.setText(list.get(position).getPtoductName());
            holder.txtPriceProd.setText(Double.toString(list.get(position).getPrice()));
            holder.txtcodeProd.setText(list.get(position).getCode());
        }
    }

    @Override
    public int getItemCount() {
      if(list!=null)
          return list.size();
      return 0;
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView txtcodeProd,txtPriceProd,txtNameProde;
        public VH(@NonNull View itemView) {
            super(itemView);
            txtcodeProd=itemView.findViewById(R.id.txtprodCode);
            txtPriceProd=itemView.findViewById(R.id.txtprodprice);
            txtNameProde=itemView.findViewById(R.id.txtprodName);
        }
    }
}
