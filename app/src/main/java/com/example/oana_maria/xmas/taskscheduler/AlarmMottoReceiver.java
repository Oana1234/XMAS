package com.example.oana_maria.xmas.taskscheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;
import static com.example.oana_maria.xmas.ui.MottoActivity.MyPREFERENCES;

/**
 * Created by Oana-Maria on 26/12/2017.
 */

public class AlarmMottoReceiver extends BroadcastReceiver {

     SharedPreferences pref;
     int position;
     // MyInterface myInterface;

//     public interface MyInterface{
//         public void myFunction();
//     }

    @Override
    public void onReceive(Context context, Intent intent) {

        pref = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        position = pref.getInt("pos", 0);

        position++;
        if (position>=47){
            position=0;
        }

        SharedPreferences.Editor editor = context.getSharedPreferences(MyPREFERENCES, MODE_PRIVATE).edit();
         editor.putInt("pos", position);
         editor.apply();

        // myInterface.myFunction();
    }
}
