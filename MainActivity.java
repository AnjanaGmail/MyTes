package com.example.admin.myapplication;

import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.Utils;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements OptionsScreenEveryWhere{

    Typeface fontIcons;
    CoordinatorLayout relativeLayout;
    MyAdapter adapter;

    private ViewStub.OnInflateListener layoutInflateListener = new ViewStub.OnInflateListener() {
        @Override
        public void onInflate(ViewStub viewStub, View view) {
            Fragment baseFragment = (Fragment) getSupportFragmentManager().findFragmentById(relativeLayout.getId());
            navigateToPanValidationFragment();
        }
    };

    @Override
    public void navigateToPanValidationFragment() {
        Utils.changeFragment(getSupportFragmentManager(), relativeLayout.getId(), EveryWhereFragment
                .newInstance(), FragmentTransaction.TRANSIT_NONE);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle(R.string.);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        fontIcons = Typeface.createFromAsset(this.getAssets(), "JioMoney.ttf");

        TextView leftIcon = (TextView) findViewById(R.id.tvLeft);
        leftIcon.setTypeface(fontIcons);
        TextView rightIcon = (TextView) findViewById(R.id.tvRightOne);
        rightIcon.setTypeface(fontIcons);
        TextView title = (TextView) findViewById(R.id.tvToolbarTitle);
        title.setText(Utils.formTitle(getResources().getString(R.string.title),
                getResources().getString(R.string.sub_title), R.style.jpb_title, R.style.jpb_subtitle, this));
        // ArrayList<Bitmap> drawables = mBitmaps;

        /*RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvToDoList);
        adapter = new MyAdapter(movieList);

        LinearLayoutManager  mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new ItemDecorator(-80));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);*/

    }


}
