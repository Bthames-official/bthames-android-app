package com.example.b_thames.adapter;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b_thames.R;
import com.example.b_thames.model.shorts_model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class shorts_adapter extends FirebaseRecyclerAdapter<shorts_model,shorts_adapter.myviewholder>
{

    public shorts_adapter(@NonNull FirebaseRecyclerOptions<shorts_model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull shorts_model model) {
        holder.setdata(model);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.shorts_page,parent,false);
        return new myviewholder(view);
    }


    static class myviewholder extends RecyclerView.ViewHolder
    {
        VideoView videoView;
        TextView name,message,rating;

        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            videoView=(VideoView)itemView.findViewById(R.id.videoView);
            name=(TextView)itemView.findViewById(R.id.name);
            message=(TextView)itemView.findViewById(R.id.message);
            rating=itemView.findViewById(R.id.rating);

        }

        void setdata(shorts_model obj)
        {
            videoView.setVideoPath(obj.getUrl());
            name.setText(obj.getName());
            message.setText(obj.getMessage());
            rating.setText(obj.getRating());

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {

                    mediaPlayer.start();
                }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }
    }

}
