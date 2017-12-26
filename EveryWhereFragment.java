package com.example.admin.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EveryWhereFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EveryWhereFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EveryWhereFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<MyClass> movieList = new ArrayList<>();
    CoordinatorLayout relativeLayout;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public static EveryWhereFragment newInstance() {
        // Required empty public constructor
        EveryWhereFragment everyWhereFragment = new EveryWhereFragment();
        return  everyWhereFragment;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EveryWhereFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EveryWhereFragment newInstance(String param1, String param2) {
        EveryWhereFragment fragment = new EveryWhereFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        relativeLayout = (CoordinatorLayout) getView().findViewById(R.id.rvToDoList);
        populateList();
    }


    void populateList() {
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.image);//assign your bitmap;
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.nimage);
        MyClass myClass = new MyClass();
        myClass.setName("Anjana");
        myClass.setImage(bitmap1);
        movieList.add(myClass);
        MyClass myClass1 = new MyClass();
        myClass1.setName("Saanu");
        myClass1.setImage(bitmap2);
        movieList.add(myClass1);
        int marginTop = 50;
        CardView card;

        View.OnDragListener drag = new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        v.setFocusable(false);
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:

                        break;
                    case DragEvent.ACTION_DRAG_EXITED:

                        break;
                    case DragEvent.ACTION_DROP:
                        // Dropped, reassign View to ViewGroup
                        v.getNextFocusDownId();
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:

                    default:
                        break;
                }
                return true;
            }
        };



        final SwipeDismissBehavior<CardView> swipe
                = new SwipeDismissBehavior();

        swipe.setSwipeDirection(
                SwipeDismissBehavior.SWIPE_DIRECTION_ANY);

        swipe.setListener(
                new SwipeDismissBehavior.OnDismissListener() {
                    @Override public void onDismiss(View view) {

                    }

                    @Override
                    public void onDragStateChanged(int state) {}
                });


        for (int i = 0; i < movieList.size(); i++) {
            card = new CardView(getContext());

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    700
            );
            params.topMargin = marginTop;
            card.setLayoutParams(params);


            // Set CardView corner radius
            card.setRadius(30);

            // Set cardView content padding
            //card.setContentPadding(15, 15, 15, 15);

            // Set a background color for CardView
            Drawable d = new BitmapDrawable(getResources(), movieList.get(i).getImage());
            //card.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));
            card.setBackground(d);

            // Set the CardView maximum elevation
            //card.setMaxCardElevation(15);
            card.setRadius(150);

            // Set CardView elevation
            card.setCardElevation(30);
            TextView tv = new TextView(getContext());
            tv.setLayoutParams(params);
            tv.setText(movieList.get(i).getName());
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
            tv.setTextColor(Color.RED);
            //tv.setBackgroundColor(Color.parseColor("#FFC6D6C3"));
            card.addView(tv);


            relativeLayout.addView(card);
            CoordinatorLayout.LayoutParams coordinatorParams =
                    ( CoordinatorLayout.LayoutParams) card.getLayoutParams();

            coordinatorParams.setBehavior(swipe);
            marginTop += 600;

            //relativeLayout.setBackground(d);

        }




    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_every_where, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
