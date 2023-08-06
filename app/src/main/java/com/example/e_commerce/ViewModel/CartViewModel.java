package com.example.e_commerce.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.e_commerce.model.CartApiResponse;
import com.example.e_commerce.repository.CartRepository;

public class CartViewModel extends AndroidViewModel
{
    private CartRepository cartRepository;

    public CartViewModel(@NonNull Application application)
    {
        super(application);
        cartRepository = new CartRepository(application);
    }

    public LiveData<CartApiResponse> getProductsInCart(int userId)
    {
        return cartRepository.getProductsInCart(userId);
    }
}