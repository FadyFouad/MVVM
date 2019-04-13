package com.etatech.mvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.etatech.mvvm.model.Place;

import java.util.List;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<Place>> liveData ;

    public LiveData<List<Place>> getPlaces (){
        return liveData;
    }


}
