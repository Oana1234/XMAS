package com.example.oana_maria.xmas.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.media.Image;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.oana_maria.xmas.R;
import com.example.oana_maria.xmas.helper.GalleryHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class MemoriesActivity extends AppCompatActivity {

    private ArrayList<Integer> images;
    private ProgressDialog pDialog;
    private GalleryHelper mAdapter;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memories);

        recyclerView = findViewById(R.id.recycler_view);
        pDialog = new ProgressDialog(this);
        images = new ArrayList<>(Arrays.asList(R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,
                R.drawable.a5,R.drawable.a6, R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,
                R.drawable.a11,R.drawable.a12, R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16));
        mAdapter = new GalleryHelper(getApplicationContext(), images);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



          /* recyclerView.addOnItemTouchListener(new GalleryAdapter.RecyclerTouchListener(getApplicationContext(), recyclerView, new GalleryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("images", images);
                bundle.putInt("position", position);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                SlideshowDialogFragment newFragment = SlideshowDialogFragment.newInstance();
                newFragment.setArguments(bundle);
                newFragment.show(ft, "slideshow");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));*/

    }
}
