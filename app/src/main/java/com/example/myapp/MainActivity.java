package com.example.myapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main, new StartPageFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.action_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, new AboutFragment()).commit();
                return true;
            case R.id.terms_using:
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, new UsingTermsFragment()).commit();
                return true;
            case R.id.home_page:
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, new StartPageFragment()).commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*public void goto2activity(View view) {
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
    }*/
}