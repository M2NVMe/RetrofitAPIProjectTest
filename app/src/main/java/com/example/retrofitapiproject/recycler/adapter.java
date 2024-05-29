package com.example.retrofitapiproject.recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofitapiproject.R;
import com.example.retrofitapiproject.TeamResponse;

import java.util.List;

import retrofit2.Call;

public class adapter extends RecyclerView.Adapter<vwhld> {
    Context context;
    List<ItemsMe> items;
    SelectListen selectListen;

    public adapter(Context context, List<ItemsMe> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public vwhld onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new vwhld(LayoutInflater.from(context).inflate(R.layout.recycle_layout_dyna,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull vwhld holder, @SuppressLint("RecyclerView") int position) {
        holder.Title.setText(items.get(position).getTitle());
        Glide.with(holder.imageView.getContext()).load(items.get(position).getBadge()).into(holder.imageView);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectListen.OnKlik(items.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
