package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import timber.log.Timber
import androidx.lifecycle.LifecycleObserver
import com.example.myapp.startpage.StartPageFragment

const val KEY_TIMER_SECONDS = "timer_seconds_key";

class MainActivity : AppCompatActivity(), LifecycleObserver {

    private lateinit var appTimer: AppTimer

    //public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        Timber.i("onCreate Called");
        appTimer = AppTimer(this.lifecycle)
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main,  StartPageFragment())
                    .commit();
        }

        if (savedInstanceState != null) {
            appTimer.secondsCount = savedInstanceState.getInt(KEY_TIMER_SECONDS, 0)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean  {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home_page -> getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, StartPageFragment()).commit()
            R.id.action_about -> getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, AboutFragment()).commit()
            R.id.terms_using -> getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, UsingTermsFragment()).commit()
        }
        return super.onOptionsItemSelected(item);
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_TIMER_SECONDS, appTimer.secondsCount);
        Timber.i("onSaveInstanceState Called");
        super.onSaveInstanceState(outState);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState);
        Timber.i("onRestoreInstanceState Called");
    }
    /** Lifecycle Methods **/
    override fun onStart() {
        super.onStart();
        Timber.i("onStart Called");
    }

    override fun onResume() {
        super.onResume();
        Timber.i("onResume Called");
    }

    override fun onPause() {
        super.onPause();
        Timber.i("onPause Called");
    }

    override fun onStop() {
        super.onStop();
        Timber.i("onStop Called");
    }

    override fun onDestroy() {
        super.onDestroy();
        Timber.i("onDestroy Called");
    }

    override fun onRestart() {
        super.onRestart();
        Timber.i("onRestart Called");
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