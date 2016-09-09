package com.reckontech.cicnp.cicnp.AddBlacklist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reckontech.cicnp.cicnp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddBlacklistFragment extends Fragment {


    public AddBlacklistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_blacklist, container, false);
    }

}
