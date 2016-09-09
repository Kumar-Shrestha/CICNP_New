package com.reckontech.cicnp.cicnp.NavBar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reckontech.cicnp.cicnp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavFragment extends Fragment {



    View view;

    RecyclerView recyclerView;
    NavigationRecyclerAdapter adapter;
    List<NavigationRecyclerDataWrapper> list = new ArrayList<>();

    public NavFragment() {
        // Required empty public constructor

        adapter = new NavigationRecyclerAdapter(list);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_nav, container, false);

        //Load Navigation Drawer List Data from Resource
        String title[] = getResources().getStringArray(R.array.navigation_title);
        String image[] = getResources().getStringArray(R.array.navigation_image);
        for(int i=0; i<title.length; i++)
        {
            list.add(new NavigationRecyclerDataWrapper(title[i], image[i]));
        }

        recyclerView = (RecyclerView) view.findViewById(R.id.nav_recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(adapter);

        return view;
    }


}
