package com.example.e_commerce.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.e_commerce.model.CartApiResponse;

public class SignInSignUpRepository
{
    private static final String TAG = CartRepository.class.getSimpleName();
    private Application application;

    public SignInSignUpRepository(Application application)
    {
        this.application = application;
    }

    public LiveData<CartApiResponse> signinsignup(int userId)
    {
        final MutableLiveData<CartApiResponse> mutableLiveData = new MutableLiveData<>();

       /* RetrofitClient.getInstance().getApi().signinsignup(userId).enqueue(new Callback<CartApiResponse>()
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
        });*/
        return mutableLiveData;
    }
}
