package com.etatech.mvvm.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.etatech.mvvm.R;
import com.etatech.mvvm.adapters.PlaceAdapter;
import com.etatech.mvvm.model.Place;
import com.etatech.mvvm.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton actionButton ;
    RecyclerView recyclerView ;
    PlaceAdapter placeAdapter ;
    List<Place> places ;
    ProgressBar progressBar ;
    MainViewModel viewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.prog_bar);
        actionButton = findViewById(R.id.fab);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.init();
        viewModel.getPlaces().observe(this, new Observer<List<Place>>() {
            @Override
            public void onChanged(@Nullable List<Place> places) {

                placeAdapter.notifyDataSetChanged();
            }
        });


        places = viewModel.getPlaces().getValue();

        recyclerView= findViewById(R.id.places_rv);
        placeAdapter = new PlaceAdapter(places,this);
        recyclerView.setAdapter(placeAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    private void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }
    private void hideProgressBar(){
        progressBar.setVisibility(View.GONE);
    }
}
