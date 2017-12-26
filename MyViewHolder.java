package com.example.admin.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 12/24/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    ViewGroup viewGroup;

    MyViewHolder(View view) {
        super(view);
        viewGroup = (ViewGroup) itemView;
    }
}
