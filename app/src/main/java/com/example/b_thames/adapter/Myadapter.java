//package com.example.b_thames.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import android.widget.VideoView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.b_thames.R;
//import com.example.b_thames.model.shorts_model;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
//public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
//
//    Context context;
//    ArrayList<shorts_model> arrayList;
//    public Myadapter(Context context, ArrayList<shorts_model> arrayList){
//        this.context =context;
//        this.arrayList =arrayList;
//    }
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        TextView name,message,rating;
//        VideoView shorts;
//
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            name= itemView.findViewById(R.id.name);
//            message=itemView.findViewById(R.id.message);
//            rating=itemView.findViewById(R.id.rating);
//            shorts=itemView.findViewById(R.id.videoView);
//
//        }
//    }
//
//    @NonNull
//    @Override
//    public Myadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View view=  LayoutInflater.from(context).inflate(R.layout.shorts_page,parent,false);
//        ViewHolder viewHolder=new ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Myadapter.ViewHolder holder, int position) {
////        holder.name.setText(arrayList.get(position).Name);
////        holder.phone_no.setText(arrayList.get(position).Phone_no);
////        holder.github.setText(arrayList.get(position).Github);
////        holder.description.setText(arrayList.get(position).Description);
////        Picasso.get().load(arrayList.get(position).getImgUrl()).fit().centerCrop().into(holder.Dp);
//        holder.name.setText(arrayList.get(position).getName());
//        holder.message.setText(arrayList.get(position).getMessage());
//        holder.rating.setText(arrayList.get(position).getR());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return arrayList.size();
//    }
//}
