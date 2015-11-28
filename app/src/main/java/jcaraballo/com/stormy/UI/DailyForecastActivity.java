package jcaraballo.com.stormy.UI;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import jcaraballo.com.stormy.R;
import jcaraballo.com.stormy.adapters.DayAdapter;
import jcaraballo.com.stormy.weather.Day;

public class DailyForecastActivity extends ListActivity {

    private Day[] mDays;
    @Bind(R.id.locationLabel)TextView locationLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        ButterKnife.bind(this);
        locationLabel.setText(MainActivity.LOCATION_NAME);
        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);

        DayAdapter dayAdapter = new DayAdapter(this, mDays);
        setListAdapter(dayAdapter);
    }

}
