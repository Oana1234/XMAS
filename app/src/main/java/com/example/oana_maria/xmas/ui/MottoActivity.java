package com.example.oana_maria.xmas.ui;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oana_maria.xmas.R;
import com.example.oana_maria.xmas.taskscheduler.AlarmMottoReceiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MottoActivity extends AppCompatActivity {

    TextView txtMotto;
    BufferedReader reader;
    ArrayList<String> lista = new ArrayList<>();
    SharedPreferences pref;
    public static final String MyPREFERENCES = "MyPrefs";
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motto);

        txtMotto = findViewById(R.id.txt_motto);
        pref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        try {
            final InputStream file = getAssets().open("citate.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while (line != null) {
                Log.d("AstrologAPP", line);
                lista.add(line);
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {

                position = pref.getInt("pos", 0);
                txtMotto.setText(lista.get(position));
            }
        };

        pref.registerOnSharedPreferenceChangeListener(listener);

    }

    private void changeMotto() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        PendingIntent pendingIntent;
        Intent myIntent;

        myIntent = new Intent(MottoActivity.this, AlarmMottoReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent, 0);
        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), (1000 * 30), pendingIntent);
    }

    protected void onResume() {
        super.onResume();
        changeMotto();
        position = pref.getInt("pos", 0);
        txtMotto.setText(lista.get(position));
    }



}