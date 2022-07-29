package com.tomboy.kengan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private ArrayList<PhotoModel> photoModel;

    public PhotoAdapter(ArrayList<PhotoModel> photoModel) {
        this.photoModel = photoModel;
    }

    @NonNull
    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_file, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.ViewHolder holder, int position) {
        holder.photoName.setText(photoModel.get(position).getPhotoName());
        Glide.with(holder.itemView.getContext()).load(photoModel.get(position).getPhoto()).into(holder.photoId);
        //holder.photoId.setImageResource(photoModel.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return photoModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView photoName;
        ImageView photoId;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            photoName = itemView.findViewById(R.id.photo_name);
            photoId = itemView.findViewById(R.id.photo_image);
        }
    }
}
