package com.example.admin.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 12/24/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private List<MyClass> moviesList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
           image = (ImageView) view.findViewById(R.id.image);
            text = (TextView) view.findViewById(R.id.text);

        }
    }

    public MyAdapter(List<MyClass> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_list_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyClass movie = moviesList.get(position);
        holder.image.setImageBitmap(movie.getImage());
        holder.text.setText(movie.getName());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
