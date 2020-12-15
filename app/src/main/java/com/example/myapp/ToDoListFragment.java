package com.example.myapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ToDoListFragment extends Fragment {

    ArrayList<String> msg = new ArrayList<>();
    TextView[] textViews;
    final static String KEY = "key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_to_do_list, container, false);

        Bundle bundle = getArguments();
        msg = bundle.getStringArrayList(KEY);

        TextView textview1 = (TextView) view.findViewById(R.id.textView);
        TextView textview2 = (TextView) view.findViewById(R.id.textView2);
        TextView textview3 = (TextView) view.findViewById(R.id.textView3);

        textViews = new TextView[]{
                textview1,
                textview2,
                textview3
        };

        int index = msg.size();

        if (index != 0) {
            for (int i = 0; i < index; i++) {
                //help[i] = textmes.get(i);
                textViews[i].setText((i + 1) + ": " + msg.get(i));
            }
        }




        return view;
    }
}