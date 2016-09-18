package com.reckontech.cicnp.cicnp.Watch;


import android.annotation.TargetApi;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

    ImageView image;

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
                        showDetails(view, position);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );


        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.watch_swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);

        image = (ImageView) view.findViewById(R.id.image);

        return view;
    }

    private void showDetails(View view, int position) {

        String imageTransitionName = "";

        ImageView imageView = (ImageView) view.findViewById(R.id.watch_recycler_row_image);

        WatchExtended watchExtended = new WatchExtended();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementReturnTransition(new DetailsTransition());
            setExitTransition(new Fade());

            watchExtended.setSharedElementEnterTransition(new DetailsTransition());
            watchExtended.setEnterTransition(new Fade());

            imageTransitionName = "TRANS_IMAGE"+position;
        }

        Bundle bundle = new Bundle();
        bundle.putString("TRANS_NAME", imageTransitionName);
        watchExtended.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.watch_coordinatorLayout, watchExtended)
                .addToBackStack(null)
                .addSharedElement(imageView, imageTransitionName)
                .commit();

    }

    @Override
    public void onRefresh() {
        recyclerView.setAlpha(0.5f);
        swipeRefreshLayout.setRefreshing(false);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public class DetailsTransition extends TransitionSet {
        public DetailsTransition() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                setOrdering(ORDERING_TOGETHER);
                addTransition(new ChangeBounds()).
                        addTransition(new ChangeTransform()).
                        addTransition(new ChangeImageTransform());
            }

        }
    }

}
