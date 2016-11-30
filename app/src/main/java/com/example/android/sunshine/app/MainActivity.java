package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            String[] data = {
                    "Today - Sunny - 88 / 63",
                    "Tomorrow - Sunny - 54 / 63",
                    "Friday - Partly Cloudy - 58 / 33",
                    "Saturday - Rainy - 72 / 61",
                    "Sunday - Sunny - 80 / 65",
                    "Monday - Gamma Ray Burst - 178 / 155",
                    "Tuesday - Foggy - 68 / 19",
                    "Wednesday - Breezy - 48 / 49",
                    "Thursday - Cloudy - 81 / 30",
            };

            // Remember, Arrays.asList() returns a non resizeable list that is still
            // attached to the original array.  So wrap it, if you do not know what
            // you may do with it in the future.
            List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));

            // Using containing Activity as context.
            ArrayAdapter<String> forecaastAdapter =
                    new ArrayAdapter<String>(getActivity(),
                            R.layout.list_item_forecast,
                            R.id.list_item_forecast_textview,
                            weekForecast );

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
