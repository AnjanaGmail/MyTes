package com.example.admin.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 12/24/2017.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<String> mContentList, mUriList;
    ArrayList<Bitmap> mBitmaps;

    MyRecyclerAdapter(ArrayList<String> contentList, ArrayList<String> uriList, ArrayList<Bitmap> drawables) {
        mContentList = contentList;
        mUriList = uriList;
        mBitmaps = drawables;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final Context ctx = parent.getContext();
        CardView.LayoutParams params = new CardView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        CardView cardView = new CardView(ctx);
        cardView.setLayoutParams(params);

        // set edges round for the cardView
        int radius = 14;
        final float scale = ctx.getResources().getDisplayMetrics().density;
        int pixels = (int) (radius * scale + 0.5f);
        cardView.setRadius(pixels);

        MyViewHolder holder = new MyViewHolder(cardView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Context ctx = holder.itemView.getContext();
        View view = getViewForCard(ctx, position);      // getView for the card
        holder.viewGroup.addView(view);
    }

    @Override
    public int getItemCount() {
        return mBitmaps.size();
    }

    public View getViewForCard(Context context, int pos) {

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        Context ctx = context;
        LinearLayout ll = new LinearLayout(ctx);
        ll.setLayoutParams(params);
        ll.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(ctx);
        tv.setText(mUriList.get(pos));
        TextView tv1 = new TextView(ctx);
        tv1.setText(mContentList.get(pos));

        // create an image view and add bitmap to it.
        ImageView imageView = new ImageView(ctx);
        imageView.setLayoutParams(params);
        imageView.getLayoutParams().height = 500;
        imageView.getLayoutParams().width = 500;
        imageView.setImageBitmap(mBitmaps.get(pos));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ll.addView(imageView);
        ll.addView(tv);
        ll.addView(tv1);

        return ll;
    }

}