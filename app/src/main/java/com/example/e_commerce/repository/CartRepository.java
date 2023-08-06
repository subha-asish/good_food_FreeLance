package com.example.e_commerce.repository;


import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.e_commerce.model.CartApiResponse;
import com.example.e_commerce.net.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartRepository
{
    private static final String TAG = CartRepository.class.getSimpleName();
    private Application application;

    public CartRepository(Application application)
    {
        this.application = application;
    }

    public LiveData<CartApiResponse> getProductsInCart(int userId)
    {
        final MutableLiveData<CartApiResponse> mutableLiveData = new MutableLiveData<>();

        RetrofitClient.getInstance().getApi().getProductsInCart(userId).enqueue(new Callback<CartApiResponse>()
        {
            @Override
            public void onResponse(Call<CartApiResponse> call, Response<CartApiResponse> response)
            {
                Log.d(TAG, "onResponse: Succeeded");

                CartApiResponse cartApiResponse = response.body();

                if (response.body() != null)
                {
                    mutableLiveData.setValue(cartApiResponse);
                    Log.d(TAG, String.valueOf(response.body().getProductsInCart()));
                }
            }

            @Override
            public void onFailure(Call<CartApiResponse> call, Throwable t)
            {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
        return mutableLiveData;
    }
}