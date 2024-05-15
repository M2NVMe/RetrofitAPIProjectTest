package com.example.retrofitapiproject.recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapiproject.R;

public class vwhld extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView Title;
    RelativeLayout relativeLayout;

    public vwhld(@NonNull View itemView) {
        super(itemView);
        imageView =itemView.findViewById(R.id.imageView);
        Title = itemView.findViewById(R.id.Title);
        relativeLayout = itemView.findViewById(R.id.utama);
    }
}
