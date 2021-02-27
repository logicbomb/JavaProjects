package com.example.javafragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 **/
public class fragment1_layout extends Fragment {
    private static final String TAG = "Fragment1";
    private Button btnNavFrag1;
    private Button btnNavFrag2;
    private Button btnNavFrag3;
    private Button btnNavSecondActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1_layout, container, false);
    btnNavFrag1 = (Button)view.findViewById(R.id.btnNavFrag1);
    btnNavFrag2 = (Button)view.findViewById(R.id.btnNavFrag2);
    btnNavFrag3 = (Button)view.findViewById(R.id.btnNavFrag3);
    btnNavSecondActivity = (Button)view.findViewById(R.id.btnNavSecondActivity);
        Log.d(TAG, "onCreate: started.");

    btnNavFrag1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), "Going to Fragment 1", Toast.LENGTH_SHORT).show();
            //navigate
            ((MainActivity)getActivity()).setmViewPager(0);
        }
    });
        btnNavFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Going to Fragment 2", Toast.LENGTH_SHORT).show();
                //navigate
                ((MainActivity)getActivity()).setmViewPager(1);
            }
        });
        btnNavFrag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Going to Fragment 3", Toast.LENGTH_SHORT).show();
                //navigate
                ((MainActivity)getActivity()).setmViewPager(2);

            }
        });
        btnNavSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Going to Second Activity", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), second_activity_layout.class);
                startActivity(intent);
                //navigate
            }
        });

    return view;
    }
}