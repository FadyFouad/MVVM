package com.etatech.mvvm.repository;

import android.arch.lifecycle.MutableLiveData;

import com.etatech.mvvm.model.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceRepository {

    private static PlaceRepository instance;
    private ArrayList<Place>places=new ArrayList<>();

    public static PlaceRepository getInstance(){
        if (instance==null){
            instance = new PlaceRepository();
        }
        return instance;
    }
    public MutableLiveData<List<Place>>getLiveData(){

        MutableLiveData<List<Place>>liveData=new MutableLiveData<>();
        liveData.setValue(places);
        return liveData;

    }
    private void setPlaces (){
        places.add(
                new Place("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Havasu Falls")
        );
        places.add(
                new Place("https://i.redd.it/tpsnoz5bzo501.jpg",
                        "Trondheim")
        );
        places.add(
                new Place("https://i.redd.it/qn7f9oqu7o501.jpg",
                        "Portugal")
        );
        places.add(
                new Place("https://i.redd.it/j6myfqglup501.jpg",
                        "Rocky Mountain National Park")
        );
        places.add(
                new Place("https://i.redd.it/0h2gm1ix6p501.jpg",
                        "Havasu Falls")
        );
        places.add(
                new Place("https://i.redd.it/k98uzl68eh501.jpg",
                        "Mahahual")
        );
        places.add(
                new Place("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Frozen Lake")
        );
        places.add(
                new Place("https://i.redd.it/obx4zydshg601.jpg",
                        "Austrailia")
        );
    }
}
