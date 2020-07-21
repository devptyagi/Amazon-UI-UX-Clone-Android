package com.dev.amazonclone.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.dev.amazonclone.R;
import com.dev.amazonclone.adapter.ImageSliderAdapter;
import com.dev.amazonclone.adapter.ItemListAdapter;
import com.dev.amazonclone.adapter.ItemListAdapter2;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageSliderAdapter imageSliderAdapter;
    SliderView sliderView;
    RecyclerView mainRecyclerView1, recycler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSliderAdapter = new ImageSliderAdapter();
        mainRecyclerView1 = findViewById(R.id.main_recycler_view);
        recycler2 = findViewById(R.id.main_recycler);
        sliderView = findViewById(R.id.main_image_slider);
        sliderView.setSliderAdapter(imageSliderAdapter);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.startAutoCycle();
        imageSliderAdapter.renewItems(fetchSliderItemList());

        mainRecyclerView1.setAdapter(new ItemListAdapter());
        mainRecyclerView1.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recycler2.setAdapter(new ItemListAdapter2());
        recycler2.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private ArrayList<String> fetchSliderItemList() {
        ArrayList<String> items = new ArrayList<>();
        items.add("https://images.pexels.com/photos/547114/pexels-photo-547114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        items.add("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
        items.add("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        return items;
    }

}