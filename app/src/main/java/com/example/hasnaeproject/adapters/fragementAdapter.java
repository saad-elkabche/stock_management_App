package com.example.hasnaeproject.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.hasnaeproject.history;
import com.example.hasnaeproject.purchases;

import java.util.ArrayList;

public class fragementAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> listFrag=new ArrayList<>();
    ArrayList<CharSequence> listTitles=new ArrayList<>();

    public fragementAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        pupulateFragment();
    }

    private void pupulateFragment() {
        listFrag.add(new purchases());
        listFrag.add(new history());

        listTitles.add("Purchases");
        listTitles.add("History");
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFrag.get(position);
    }

    @Override
    public int getCount() {
        return listFrag.size();
    }
}
