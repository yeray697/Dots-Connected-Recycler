package com.yeray697.dotsconnectedrecycler;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DotLineRecyclerAdapter adapter;
    ArrayList<RecyclerData> data;
    DotLineRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();
        data.add(new RecyclerData(R.mipmap.ic_launcher, "Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1", "aaaaaaaaaaaa"));
        data.add(new RecyclerData(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher), "Title 2", "10:05"));

        adapter = new CustomAdapter(this, data);
        recyclerView = ((DotLineRecyclerView) findViewById(R.id.recyclerView));
        recyclerView.getRecyclerView().setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.getRecyclerView().setAdapter(adapter);
        recyclerView.setLineColor(Color.YELLOW);
    }
}