package com.reckontech.cicnp.cicnp.Watch;


import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

        Bundle bundle = getArguments();
        String transitionName = "";

        if (bundle != null) {
            transitionName = bundle.getString("TRANS_NAME");
        }

        view = inflater.inflate(R.layout.fragment_watch_extended, container, false);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ImageView imageView = (ImageView) view.findViewById(R.id.watch_recycler_row_image);
            imageView.setTransitionName(transitionName);
        }

        return view;
    }

}
