package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;

public class DisplayMessageActivity extends AppCompatActivity implements OnClickListener {

    TextView textview;
    //EditText edittext;
    Button button;

    int count = 0;
    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    public final static String INDEX = "INDEX";

    //String[] list = new String[3];

    ArrayList<String> list = new ArrayList<>();
    int index = 0;

    //Button button1 = (Button) findViewById(R.id.button1);
    //Button button2 = (Button) findViewById(R.id.button2);

    //button1.setOnClickListener(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        //final Button button1 = (Button) findViewById(R.id.button1);
        //final Button button2 = (Button) findViewById(R.id.button2);
        //edittext = (EditText) findViewById(R.id.editView);
        //textview = (TextView) findViewById(R.id.textView4);
        Intent intent = getIntent();

        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //String message2 = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        //TextView textView = new TextView(this);
        //TextView textView1 = new TextView(this);
        //textView.setTextSize(40);
        //textView1.setTextSize(40);
        //textview.setText("1");
        //textView1.setText(message2);

        //setContentView(textView);

    }

    /*public void addsome(View view){
        //Intent intent = new Intent(this, ToDoListActivity.class);
        /*edittext = (EditText) findViewById(R.id.editView);
        button = (Button) findViewById(R.id.button);
        //edittext.setTextSize(50);

        String textmes = edittext.getText().toString();

        if (textmes.length() >= 6 ){
            this.count++;
            intent.putExtra(EXTRA_MESSAGE, textmes);
            intent.putExtra(INDEX, String.valueOf(this.count));
            edittext.setText("");

        }

        if (this.count >= 3){
            button.setEnabled(false);
        }*/

        //startActivity(intent);



        //this.count++;

        //Toast toast = Toast.makeText(this, count, Toast.LENGTH_LONG);
        //toast.show();
        //textview = (TextView) findViewById(R.id.textView4);

        //textview.setTextSize(40);
        //textview.setText(String.valueOf(this.count));
        //setContentView(textview);
        /*Intent intent = new Intent(this, DisplayMessageActivity.class);
        //Intent intent = getIntent();
        //EditText edittext = (EditText) findViewById(R.id.editView);
        switch (view.getId()){
            case R.id.button1:{
                //edittext.setText("1");
                //setContentView(edittext);
                Toast toast = Toast.makeText(this, "1", Toast.LENGTH_LONG);
                toast.show();
            }

            case R.id.button2:{
                //edittext.setText("2");
                //setContentView(edittext);
                Toast toast = Toast.makeText(this, "2", Toast.LENGTH_LONG);
                toast.show();
            }
        }

    }*/

    //public void goto3activity(View view){
        //Intent intent = new Intent(this, ToDoListActivity.class);
        //startActivity(intent);
        //setContentView(R.layout.activity_to_do_list);
        //Intent intent = new Intent(this, ToDoListActivity.class);
        //Intent intent = getIntent();
        //startActivity(intent);
    //}

    @Override
    public void onClick(View v) {

        EditText edittext = (EditText) findViewById(R.id.editView);
        Button buttonno = (Button) findViewById(R.id.button1);
        //String[] list = new String[3];
        //int index = 0;

        switch (v.getId()){
            case R.id.button1:{
                //edittext.setTextSize(10);
                //edittext.setText("1");
                //setContentView(edittext);
                //Toast toast = Toast.makeText(this, "1", Toast.LENGTH_LONG);
                //toast.show();

                //if (index <= 2){


                //list[index] = edittext.getText().toString();
                if (edittext.getText().toString().length() >= 6){
                    list.add(edittext.getText().toString());

                    if (list.get(index).length() >= 6){
                        index++;
                        edittext.setText("");
                        Toast toast = Toast.makeText(this, "Справу додано успішно", Toast.LENGTH_LONG);
                        toast.show();
                    }
                    else {
                        list.set(index, "");
                        Toast toast = Toast.makeText(this, "Більше 6 символів", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }

                if (index >= 3){
                    buttonno.setEnabled(false);
                    edittext.setEnabled(false);
                }

            } break;

            case R.id.button2:{
                //edittext.setText("2");
                //setContentView(edittext);
                //Toast toast = Toast.makeText(this, "2", Toast.LENGTH_LONG);
                //toast.show();

                Intent intent = new Intent(this, ToDoListActivity.class);
                intent.putExtra(EXTRA_MESSAGE, list);
                intent.putExtra(INDEX, this.count);

                startActivity(intent);
            }   break;
        }

    }
}