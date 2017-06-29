package com.lmntrx.android.splashtimerbroadcastsharepreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    int c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final TextView numberTV = (TextView) findViewById(R.id.counterTV);

        SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);

        int currentCounter = sharedPreferences.getInt("NUMBER", 0);

        numberTV.setText(String.valueOf(currentCounter));


        sharedPreferences.registerOnSharedPreferenceChangeListener(
                new SharedPreferences.OnSharedPreferenceChangeListener() {
                    @Override
                    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
                        if (s.equals("NUMBER")) {
                            c = sharedPreferences.getInt("NUMBER", 0);
                            numberTV.setText(String.valueOf(c));
                        }
                    }
                }
        );

    }

    public void increment(View view) {
        Intent intent = new Intent(this, IncrementRequestReceiver.class);
        sendBroadcast(intent);
    }
}
