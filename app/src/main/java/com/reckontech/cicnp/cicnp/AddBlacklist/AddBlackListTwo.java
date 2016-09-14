package com.reckontech.cicnp.cicnp.AddBlacklist;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.reckontech.cicnp.cicnp.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddBlackListTwo extends Fragment {

    DatePickerDialog datePickerDialog;
    Calendar calendar;
    int year_selected, month_selected, day_selected;

    View view;

    TextView textView_dateOfBirth;

    public AddBlackListTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_black_list_two, container, false);

        calendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                textView_dateOfBirth.setText(new StringBuilder().append(year + 1)
                        .append("/").append(monthOfYear).append("/").append(dayOfMonth)
                        .append(" "));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) );



        textView_dateOfBirth = (TextView) view.findViewById(R.id.addBlackList_editText_dateOfBirth);
        textView_dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        return view;
    }


}
