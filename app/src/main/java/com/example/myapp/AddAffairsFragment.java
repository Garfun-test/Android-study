package com.example.myapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddAffairsFragment extends Fragment {

    Fragment todolist = new ToDoListFragment();
    final static String KEY = "key";

    ArrayList<String> list = new ArrayList<>();
    int index = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_add_affairs, container, false);

        final Button buttonAdd = (Button) view.findViewById(R.id.button1);
        Button buttonNext = (Button) view.findViewById(R.id.button2);

        final EditText editText = (EditText) view.findViewById(R.id.editView);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().length() >= 6) {
                    list.add(editText.getText().toString());
                    index++;
                    editText.setText("");
                    Toast toast = Toast.makeText(v.getContext(), "Справу додано успішно", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(v.getContext(), "Більше 6 символів", Toast.LENGTH_SHORT);
                    toast.show();
                    }

                if (index >= 3) {
                buttonAdd.setEnabled(false);
                editText.setEnabled(false);
                }
            }

        });


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putStringArrayList(KEY, list);
                todolist.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //fragmentTransaction.replace(R.id.fragment_start_page, addlist);
                //fragmentTransaction.add(R.id.fragment_start_page, new AddAffairsFragment()).commit();
                fragmentTransaction.replace(R.id.activity_main, todolist).commit();

                //onDestroyView();
                //fragmentTransaction.show(StartPageFragment.this).commit();

                //.commit();
                //fragmentTransaction.commit();




            }
        });

        return view;
    }
}