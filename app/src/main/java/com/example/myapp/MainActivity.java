package com.example.myapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goto2activity(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


        Toast toast = Toast.makeText(this, "Хеллоу " + message, Toast.LENGTH_LONG);
        toast.show();
    }

    public void aboutdev(View view){
        Toast toast = Toast.makeText(this, "Розроблена Бережанським Дмитром", Toast.LENGTH_LONG);
        toast.show();
    }
}