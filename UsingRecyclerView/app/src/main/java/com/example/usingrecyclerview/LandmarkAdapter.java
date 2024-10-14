package com.example.usingrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkViewHolder> {
    private List<Landmark> landmarks;
    public LandmarkAdapter(List<Landmark> landmarks){
        this.landmarks = landmarks;
    }
    @NonNull
    @Override
    public LandmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_landmark, parent, false);
        return new LandmarkViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkViewHolder holder, int position) {
        Landmark currentItem = landmarks.get(position);
        holder.imageView.setImageResource(currentItem.getImageResId());
        holder.textView.setText(currentItem.getName());
    }

    @Override
    public int getItemCount() {
        return landmarks.size();
    }

    static class LandmarkViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        LandmarkViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
