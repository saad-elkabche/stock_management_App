package com.example.hasnaeproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasnaeproject.adapters.historyAdapter;
import com.example.hasnaeproject.databaseStuff.mytools;
import com.example.hasnaeproject.databaseStuff.purchase;
import com.example.hasnaeproject.databaseStuff.viewModel;

import java.util.List;


public class history extends Fragment {

    viewModel vm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_history, container, false);
        RecyclerView rc=v.findViewById(R.id.rchistory);
        historyAdapter adapter=new historyAdapter(getContext());
        vm=new ViewModelProvider(this).get(viewModel.class);
        vm.getPurchase().observe(getActivity(), new Observer<List<purchase>>() {
            @Override
            public void onChanged(List<purchase> purchases) {
                adapter.setList(purchases);
            }
        });
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
       rc.setAdapter(adapter);
       /* mytools tool=new mytools(getActivity().getApplication());
        List<purchase> list=tool.getPurchases();
         List<purchase> pur=mytool.getp
        rc.setLayoutManager(new LinearLayoutManager(getContext()));
        rc.setAdapter(adapter);*/




        return v;
    }
}