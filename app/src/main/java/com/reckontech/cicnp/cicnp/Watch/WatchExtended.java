package com.reckontech.cicnp.cicnp.Watch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reckontech.cicnp.cicnp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WatchExtended extends Fragment {


    View view;

    public WatchExtended() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_watch_extended, container, false);



        return view;
    }

}
