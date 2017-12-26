package com.example.oana_maria.xmas.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
        images = new ArrayList<>(Arrays.asList(R.drawable.education5));

        mAdapter = new GalleryHelper(getApplicationContext(), images);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

          recyclerView.addOnItemTouchListener(new GalleryHelper.RecycleTouchListener(getApplicationContext(), recyclerView, new GalleryHelper.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("images", images);
                bundle.putInt("position", position);

                android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                SlideshowDialogFragment newFragment = SlideshowDialogFragment.newInstance();
                newFragment.setArguments(bundle);
                newFragment.show(ft,"slideshow");
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

    }
}
