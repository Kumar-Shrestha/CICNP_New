package com.reckontech.cicnp.cicnp.Watch;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reckontech.cicnp.cicnp.R;
import com.reckontech.cicnp.cicnp.RecyclerView.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WatchFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    View view;

    RecyclerView recyclerView;
    WatchRecyclerAdapter adapter;
    List<WatchRecyclerDataWrapper> list = new ArrayList<>();

    SwipeRefreshLayout swipeRefreshLayout;


    public WatchFragment() {
        // Required empty public constructor
        adapter = new WatchRecyclerAdapter(list);
        list.add(new WatchRecyclerDataWrapper("kumar","9841012740","217171"));
        list.add(new WatchRecyclerDataWrapper("kumar","9841012740","217171"));
        list.add(new WatchRecyclerDataWrapper("kumar","9841012740","217171"));
        list.add(new WatchRecyclerDataWrapper("kumar","9841012740","217171"));
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_watch, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.watch_recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        extendWatch(view);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );


        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.watch_swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);


        return view;
    }

    @Override
    public void onRefresh() {
        recyclerView.setAlpha(0.5f);
        swipeRefreshLayout.setRefreshing(false);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public class DetailsTransition extends TransitionSet {
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public DetailsTransition() {
            setOrdering(ORDERING_TOGETHER);
            addTransition(new ChangeBounds()).
                    addTransition(new ChangeTransform()).
                    addTransition(new ChangeImageTransform());
        }
    }

    public void extendWatch(final View view){

/*
        // Check that the device is running lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            WatchExtended watchExtended = new WatchExtended();

            // Inflate transitions to apply
            Transition changeTransform = TransitionInflater.from(getContext()).
                    inflateTransition(R.transition.change_image_transform);
            Transition explodeTransform = TransitionInflater.from(getContext()).
                    inflateTransition(android.R.transition.explode);

            // Setup exit transition on first fragment
            this.setSharedElementReturnTransition(changeTransform);
            this.setExitTransition(changeTransform);

            // Setup enter transition on second fragment
            watchExtended.setSharedElementEnterTransition(changeTransform);
            watchExtended.setEnterTransition(changeTransform);

            // Find the shared element (in Fragment A)
            ImageView imageView = (ImageView) view.findViewById(R.id.watch_recycler_row_image);

            // Add second fragment by replacing first
            FragmentTransaction ft = getFragmentManager().beginTransaction()
                    .replace(R.id.watch_coordinatorLayout, watchExtended)
                    .addToBackStack("transaction")
                    .addSharedElement(imageView, "watch_transition_image");
            // Apply the transaction
            ft.commit();
        }
        else {
            // Code to run on older devices
        }*/


       final WatchExtended details = new WatchExtended();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            details.setSharedElementEnterTransition(new DetailsTransition());
            details.setEnterTransition(new Fade().setDuration(100));
            setExitTransition(new Fade());
            details.setSharedElementReturnTransition(new DetailsTransition());
        }

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addSharedElement(view.findViewById(R.id.watch_recycler_row_image), "watch_transition_image")
                        .replace(R.id.watch_coordinatorLayout, details)
                        .addToBackStack(null)
                        .commit();
            }
        });


    }
}
