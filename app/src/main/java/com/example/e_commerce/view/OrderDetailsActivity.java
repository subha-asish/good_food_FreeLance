package com.example.e_commerce.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.e_commerce.R;
import com.example.e_commerce.databinding.OrderDetailsBinding;

public class OrderDetailsActivity extends AppCompatActivity
{
    OrderDetailsBinding orderDetailsBinding;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        orderDetailsBinding = DataBindingUtil.setContentView(this, R.layout.order_details);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));
    }
}
