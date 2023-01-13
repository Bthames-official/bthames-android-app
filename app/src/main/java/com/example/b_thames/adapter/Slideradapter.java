package com.example.b_thames.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.b_thames.R;
import com.example.b_thames.activity.home_screen;
import com.example.b_thames.model.Model_url;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Slideradapter extends SliderViewAdapter<Slideradapter.Holder> {
    Context context;
    List<String> arrayList;

    public Slideradapter(Context context,List<String> list){

        this.arrayList=list;
        this.context=context;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.imageslider,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
        Picasso.get().load(arrayList.get(position)).fit().into(viewHolder.imageView);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    public class Holder extends  SliderViewAdapter.ViewHolder{

        ImageView imageView;

        public Holder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.slide_img);
        }
    }
}
