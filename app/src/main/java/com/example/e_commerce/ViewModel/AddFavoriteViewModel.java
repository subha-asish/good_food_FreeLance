package com.example.e_commerce.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.e_commerce.model.Favorite;
import com.example.e_commerce.repository.AddFavoriteRepository;
import com.example.e_commerce.utils.RequestCallback;
import okhttp3.ResponseBody;

public class AddFavoriteViewModel extends AndroidViewModel
{
    private AddFavoriteRepository addFavoriteRepository;

    public AddFavoriteViewModel(@NonNull Application application)
    {
        super(application);
        addFavoriteRepository = new AddFavoriteRepository(application);
    }

    public LiveData<ResponseBody> addFavorite(Favorite favorite, RequestCallback callback)
    {
        return addFavoriteRepository.addFavorite(favorite,callback);
    }
}