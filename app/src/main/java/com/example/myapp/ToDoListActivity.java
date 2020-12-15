package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {

    TextView[] textViews, textToDo;
    //TextView textView = (TextView) findViewById(R.id.textView);
    //TextView textView1 = (TextView) findViewById(R.id.textView2);
    //TextView textView2 = (TextView) findViewById(R.id.textView3);

    //ArrayList<String> textmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        //textviews = new TextView[3]{

        //}
        TextView textview1 = (TextView) findViewById(R.id.textView);
        TextView textview2 = (TextView) findViewById(R.id.textView2);
        TextView textview3 = (TextView) findViewById(R.id.textView3);

        textViews = new TextView[]{
            textview1,
            textview2,
            textview3
        };

        Intent intent = getIntent();

        //textview = new TextView(this);
        //textview1 = (TextView) findViewById(R.id.textView2);
        //textview2 = (TextView) findViewById(R.id.textView3);

        //textViews = new TextView[]{
          //      new TextView (this),
            //    new TextView (this),
              //  new TextView (this)
        //};

        //Intent intent = getIntent();
        ArrayList<String> textmes = (ArrayList<String>) intent.getSerializableExtra(DisplayMessageActivity.EXTRA_MESSAGE);
        int index = textmes.size();
        //System.out.println(textmes);
        //System.out.println(index);

        if (index != 0) {
            for (int i = 0; i < index; i++) {
                //help[i] = textmes.get(i);
                textViews[i].setText((i+1) + ": " + textmes.get(i));



                /*switch (i) {
                    case 0: textview1.setText(i + ": " + textmes.get(i)); break;
                    case 1: textview2.setText(i + ": " + textmes.get(i)); break;
                    case 2: textview3.setText(i + ": " + textmes.get(i)); break;
                //textViews[i].setTextSize(40);
                //setContentView(textViews[i]);
                }*/
            }

        //setContentView(R.layout.activity_to_do_list);

       // textToDo = new TextView[]{
              //  textToDo[0] = (TextView) findViewById(R.id.textView),
            //    textToDo[1] = (TextView) findViewById(R.id.textView2),
          //      textToDo[2] = (TextView) findViewById(R.id.textView3)
        //};

        //textToDo[0].setText("1++");

        //setContentView(R.layout.activity_to_do_list);
        }
        //startActivity(intent);

        //int a = 0/index;

        //if (index > 0 && textmes.get(0).length() > 0){

            /*for (int i = 0; i < index; i++){
                textViews[i].setText(textmes.get(i));
                setContentView(textViews);
            }*/
        //}

        //int index = 0;
        //index = Integer.parseInt(intent.getStringExtra(DisplayMessageActivity.INDEX));

        /*if (index >= 1){
            for (int i = 0; i < index; i++){
                textViews[i].setText(textmes);
                setContentView(textViews[i]);
            }
        }*/
        //setContentView(R);
    }
}
