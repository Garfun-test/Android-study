package com.example.myapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Button;

public class StartPageFragment extends Fragment {

    final String LOG_TAG = "StartPage";
    //FragmentManager transaction  = getSupportFragmentManager().beginTransaction();
    Fragment addlist = new AddAffairsFragment();

    /*@Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.d(LOG_TAG,"Destroyed");
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_start_page, container, false);

        //container = (FrameLayout) view.findViewById(R.id.container);

        Button buttonEnter = (Button) view.findViewById(R.id.button);
        //Button buttonDev = (Button) view.findViewById(R.id.button2);

        final EditText editText = (EditText) view.findViewById(R.id.edit_message);

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //fragmentTransaction.replace(R.id.fragment_start_page, addlist);
                //fragmentTransaction.add(R.id.fragment_start_page, new AddAffairsFragment()).commit();
                fragmentTransaction.replace(R.id.activity_main, addlist).commit();

                //onDestroyView();
                //fragmentTransaction.show(StartPageFragment.this).commit();

                                        //.commit();
                //fragmentTransaction.commit();



                Toast toast = Toast.makeText(v.getContext(), "Хеллоу " + editText.getText().toString(), Toast.LENGTH_SHORT);
                toast.show();

                //transaction.replace(R.layout.fragment_start_page, new AddAffairsFragment()).commit();
            }
        });

        return view;
    }
}