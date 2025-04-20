package com.example.lutemon.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.lutemon.R;
import com.example.lutemon.lutemon.Lutemon;

import java.util.List;

public class LutemonAdapter extends RecyclerView.Adapter<LutemonAdapter.LutemonViewHolder> {

    private List<Lutemon> lutemons;
    private static Lutemon selectedLutemon;
    public LutemonAdapter(List<Lutemon> lutemons) {
        this.lutemons = lutemons;
    }

    public class LutemonViewHolder extends RecyclerView.ViewHolder {
        public ImageView lutemonImageView;
        public TextView lutemonNameTextView;
        public TextView lutemonStatsTextView;

        public LutemonViewHolder(View itemView) {
            super(itemView);
            lutemonImageView = itemView.findViewById(R.id.iv_lutemon_image);
            lutemonNameTextView = itemView.findViewById(R.id.tv_lutemon_name);
            lutemonStatsTextView = itemView.findViewById(R.id.tv_lutemon_stats);

            itemView.setOnClickListener(V -> {
                if (selectedLutemon != null) {
                    selectedLutemon.setSelected(false);
                }
                selectedLutemon = lutemons.get(getAdapterPosition());
                selectedLutemon.setSelected(true);
                notifyDataSetChanged();
            });
        }
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lutemon, parent, false);
        return new LutemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);
        holder.lutemonImageView.setImageResource(lutemon.getImageSource());
        holder.lutemonNameTextView.setText(lutemon.getName());
        holder.lutemonStatsTextView.setText(lutemon.getStats());

        if (lutemon.equals(selectedLutemon)){
            holder.itemView.setBackgroundColor(Color.DKGRAY);
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    public static Lutemon getSelectedLutemon() {
        return selectedLutemon;
    }
}
