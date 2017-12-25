package com.example.oana_maria.xmas.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oana_maria.xmas.R;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    ImageView image1, image2, image3;
    TextView text1, text2, text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = findViewById(R.id.image_categori);
        image2 = findViewById(R.id.image_categorie2);
        image3 = findViewById(R.id.image_categorie3);

        text1 = findViewById(R.id.title_categ);
        text2 = findViewById(R.id.title_categ2);
        text3 = findViewById(R.id.title_categ3);

        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_categori:
                Intent intent = new Intent(this, HoroscopActivity.class);
                startActivity(intent);
                break;
            case R.id.image_categorie2:
                Intent intent2 = new Intent(this, MemoriesActivity.class);
                startActivity(intent2);
                break;
            case R.id.image_categorie3:
                Intent intent3 = new Intent(this, MottoActivity.class);
                startActivity(intent3);
                break;
        }
    }

}