package com.example.oana_maria.xmas.ui;

import android.media.MediaPlayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oana_maria.xmas.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class HoroscopActivity extends AppCompatActivity {

    Button btnRoar;
    ImageView imageViewLine;
    TextView txtHoroscope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscop);

        btnRoar = findViewById(R.id.btn_roar);
        imageViewLine = findViewById(R.id.line);
        txtHoroscope = findViewById(R.id.txt_horoscope);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.lionsound);

        btnRoar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        downloadContent();
    }

    private void downloadContent() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder builder = new StringBuilder();

                try {

                    Document doc = Jsoup.connect("http://www.eastrolog.ro/horoscop-zilnic/horoscop-leu.php").get();
                    //       String title = doc.title();
                    String body = doc.body().text();
                    String word = "Leul azi";
                    String word2 = "Horoscop Leu ieri";
                    String horoscop;
                    int position1 = body.indexOf(word);
                    int position2 = body.indexOf(word2);
                    horoscop = body.substring(position1, position2);
                    builder.append(horoscop);

                } catch (IOException e) {
                    builder.append("Error : ").append(e.getMessage()).append("\n");
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtHoroscope.setText(builder.toString());

                    }
                });
            }
        }).start();
    }
}
