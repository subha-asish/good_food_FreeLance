package com.example.e_commerce.view;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import com.example.e_commerce.R;
import com.example.e_commerce.adapter.AllCategoryAdapter;

import com.example.e_commerce.model.AllCategory;

public class AllCategoryActivity extends AppCompatActivity
{
    GridView gridView;
    ArrayList<AllCategory> list;
    AllCategoryAdapter adapterGrid;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        gridList();

        adapterGrid = new AllCategoryAdapter(this,list);
        gridView.setAdapter(adapterGrid);
    }

    private void gridList()
    {
        list = new ArrayList<AllCategory>();

        list.add(new AllCategory("Fashion",R.drawable.shoes1,"No Dec","150"));
        list.add(new AllCategory("Mobiles",R.drawable.shoes2,"No Dec","150"));
        list.add(new AllCategory("Electronics",R.drawable.shoes3,"No Dec","150"));
        list.add(new AllCategory("Home",R.drawable.shoes3,"No Dec","150"));
        list.add(new AllCategory("Appliances",R.drawable.shoes3,"No Dec","150"));
        list.add(new AllCategory("Beauty",R.drawable.shoes3,"No Dec","150"));
        list.add(new AllCategory("Toys & Baby",R.drawable.shoes3,"No Dec","150"));
        list.add(new AllCategory("Sports & More",R.drawable.shoes3,"No Dec","150"));
        list.add(new AllCategory("Furniture",R.drawable.shoes3,"No Dec","150"));
        list.add(new AllCategory("Flights",R.drawable.shoes3,"No Dec","150"));
        list.add(new AllCategory("Gift cards",R.drawable.shoes3,"No Dec","150"));
    }
}