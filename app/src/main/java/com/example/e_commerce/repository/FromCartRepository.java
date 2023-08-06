package com.example.e_commerce.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.e_commerce.net.RetrofitClient;
import com.example.e_commerce.utils.RequestCallback;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FromCartRepository
{
    private static final String TAG = FromCartRepository.class.getSimpleName();
    private Application application;

    public FromCartRepository(Application application)
    {
        this.application = application;
    }

    public LiveData<ResponseBody> removeFromCart(int userId, int productId, RequestCallback callback)
    {
        final MutableLiveData<ResponseBody> mutableLiveData = new MutableLiveData<>();
        RetrofitClient.getInstance().getApi().removeFromCart(userId, productId).enqueue(new Callback<ResponseBody>()
        {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response)
            {
                Log.d("onResponse", "" + response.code());

                if(response.code() == 200)
                {
                    callback.onCallBack();
                }

                ResponseBody responseBody = response.body();

                if (response.body() != null)
                {
                    mutableLiveData.setValue(responseBody);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t)
            {
                Log.d("onFailure", "" + t.getMessage());
            }
        });

        return mutableLiveData;
    }
}