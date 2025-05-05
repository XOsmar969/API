package com.example.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<Team> teamList;

    public TeamAdapter(List<Team> teamList) {
        this.teamList = teamList;

    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.tvNamaTim.setText(team.strTeam);
        holder.tvStadium.setText(team.strStadium);

        Glide.with(holder.itemView.getContext())
                .load(team.strBadge)
                .into(holder.imgBadge);

    }


    @Override
    public int getItemCount() {
        return teamList.size();
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaTim, tvStadium;
        ImageView imgBadge;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaTim = itemView.findViewById(R.id.tvNamaTim);
            tvStadium = itemView.findViewById(R.id.tvStadium);
            imgBadge = itemView.findViewById(R.id.GambarBadge);

 }
    }
}
