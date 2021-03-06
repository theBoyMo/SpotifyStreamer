package com.example.spotifystreamer.base;


/**
 * Adding the ToolBar to the Activity - Thanks to CodePath
 * https://github.com/codepath/android_guides/wiki/Defining-The-ActionBar
 *
 * Preserving ListView on returning to Activity via up 'home' button - fix thanks to vikki_logs
 * http://stackoverflow.com/questions/22182888/actionbar-up-button-destroys-parent-activity-back-does-not
 *
 */


import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.spotifystreamer.R;
import com.example.spotifystreamer.activities.SettingsActivity;

/**
 * BaseActivity provides all the common functionality for the other activities of the app
 */

public class BaseActivity extends AppCompatActivity {

    private static final String LOG_TAG = BaseActivity.class.getSimpleName();
    private final boolean L = false;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(L) Log.d(LOG_TAG, "Calling onCreated()");

        if(savedInstanceState == null)
            if(L) Log.d(LOG_TAG, "Starting the activity for the first time");
        else
            if(L) Log.d(LOG_TAG, "Restoring activities instance state");

        // set the content view based on device size
        Configuration config = getResources().getConfiguration();

        // tablet device >= 600dp in width
        if(config.smallestScreenWidthDp >= 600) {
            if((config.orientation == config.ORIENTATION_PORTRAIT))
                setContentView(R.layout.fragment_container_tablet_portrait);
            else
                setContentView(R.layout.fragment_container_tablet_landscape);
        }
        // phone
        else
            setContentView(R.layout.fragment_container);


        // Instantiate & configure the ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_toolbar);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
            // 'drop shadow' effect is only supported in APi 21+
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                toolbar.setElevation(10.0f);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_settings) {
            startActivity(new Intent(BaseActivity.this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // Activity LifeCycle methods, added to aid debugging

    @Override
    protected void onRestart() {
        super.onRestart();
        if(L) Log.d(LOG_TAG, "Calling onRestart()");
    }



    @Override
    protected void onStart() {
        super.onStart();
        if(L) Log.d(LOG_TAG, "Calling onStart()");
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(L) Log.d(LOG_TAG, "Calling onResume()");
    }


    @Override
    protected void onPause() {
        super.onPause();
        if(L) Log.d(LOG_TAG, "Calling onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        if(L) Log.d(LOG_TAG, "Calling onStop()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(L) Log.d(LOG_TAG, "Calling onDestroy()");
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(L) Log.d(LOG_TAG, "Calling onBackPressed()");
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        if(L) Log.d(LOG_TAG, "Calling onSaveInstanceState()");
    }


    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if(L) Log.d(LOG_TAG, "Calling onAttachFragment()");
    }



}
