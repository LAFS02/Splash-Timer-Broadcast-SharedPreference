package com.lmntrx.android.splashtimerbroadcastsharepreference;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class IncrementRequestReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);

        int currentValue = sharedPreferences.getInt("NUMBER",0);

        sharedPreferences.edit().putInt("NUMBER", ++currentValue).apply();



    }
}
