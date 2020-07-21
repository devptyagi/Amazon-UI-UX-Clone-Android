package com.dev.amazonclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dev.amazonclone.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class ImageSliderAdapter extends SliderViewAdapter<ImageSliderAdapter.ImageSliderViewHolder> {

    ArrayList<String> mSliderItems = new ArrayList<>();

    public void renewItems(ArrayList<String> sliderItem) {
        mSliderItems = sliderItem;
        notifyDataSetChanged();
    }

    @Override
    public ImageSliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_slider, parent, false);
        return new ImageSliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageSliderViewHolder viewHolder, int position) {
        String sliderItem = mSliderItems.get(position);
        Glide.with(viewHolder.imageView.getContext())
                .load(sliderItem)
                .centerCrop()
                .into(viewHolder.imageView);
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    public class ImageSliderViewHolder extends SliderViewAdapter.ViewHolder {

        ImageView imageView;

        public ImageSliderViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_slider_iv);
        }

    }
}
