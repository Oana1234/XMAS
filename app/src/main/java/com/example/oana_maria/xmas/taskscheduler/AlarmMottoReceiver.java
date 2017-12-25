package com.example.oana_maria.xmas.taskscheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.oana_maria.xmas.ui.MottoActivity;

/**
 * Created by Oana-Maria on 22/12/2017.
 */

public class AlarmMottoReceiver extends BroadcastReceiver {


    private  SharedPreferences sharedPosition;
    private int i;


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "New Motto", Toast.LENGTH_LONG).show();
        sharedPosition.getInt(MottoActivity.MyPREFERENCES,i );
        i++;

        SharedPreferences.Editor edit = sharedPosition.edit();
        edit.putInt(MottoActivity.MyPREFERENCES, i);
        edit.commit();



    }
}
