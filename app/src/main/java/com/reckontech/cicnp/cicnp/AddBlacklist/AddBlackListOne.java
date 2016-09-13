package com.reckontech.cicnp.cicnp.AddBlacklist;


import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.reckontech.cicnp.cicnp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddBlackListOne extends Fragment implements View.OnClickListener {

    CoordinatorLayout coordinatorLayout;

    View view;

    ImageView imageView;
    EditText editText_firstName;
    EditText editText_middleName;
    EditText editText_lastName;

    Button button_next;

    public AddBlackListOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_add_black_list_one, container, false);

        coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.addBlackList_coordinatorLayout);

        imageView = (ImageView) view.findViewById(R.id.addBlackList_photo);

        editText_firstName = (EditText) view.findViewById(R.id.addBlackList_editText_firstName);
        editText_middleName = (EditText) view.findViewById(R.id.addBlackList_editText_middleName);
        editText_lastName = (EditText) view.findViewById(R.id.addBlackList_editText_lastName);

        button_next = (Button) view.findViewById(R.id.addBlackList_button_next_one);
        button_next.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.addBlackList_button_next_one:

                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                AddBlackListTwo registrationFragment = new AddBlackListTwo();

                fragmentTransaction.replace(R.id.addBlackList_coordinatorLayout, registrationFragment);
                fragmentTransaction.addToBackStack("AddBlackListOne");
                fragmentTransaction.commit();

                break;
        }
    }
}
