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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();
        data.add(new RecyclerData(R.mipmap.ic_launcher, "Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1", "aaaaaaaaaaaa"));
        data.add(new RecyclerData(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher), "Title 2", "10:05"));
        data.add(new RecyclerData("Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3", ""));
        data.add(new RecyclerData("http://findicons.com/files/icons/367/ifunny/128/dog.png", "Title 4", ""));
        data.add(new RecyclerData(R.mipmap.ic_launcher, "Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1", "aaaaaaaaaaaa"));
        data.add(new RecyclerData(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher), "Title 2", "10:05"));
        data.add(new RecyclerData("Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3", ""));
        data.add(new RecyclerData("http://findicons.com/files/icons/367/ifunny/128/dog.png", "Title 4", ""));
        data.add(new RecyclerData(R.mipmap.ic_launcher, "Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1", "aaaaaaaaaaaa"));
        data.add(new RecyclerData(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher), "Title 2", "10:05"));
        data.add(new RecyclerData("Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3", ""));
        data.add(new RecyclerData("http://findicons.com/files/icons/367/ifunny/128/dog.png", "Title 4", ""));
        data.add(new RecyclerData(R.mipmap.ic_launcher, "Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1", "aaaaaaaaaaaa"));
        data.add(new RecyclerData(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher), "Title 2", "10:05"));
        data.add(new RecyclerData("Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3", ""));
        data.add(new RecyclerData("http://findicons.com/files/icons/367/ifunny/128/dog.png", "Title 4", ""));
        data.add(new RecyclerData(R.mipmap.ic_launcher, "Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1", "aaaaaaaaaaaa"));
        data.add(new RecyclerData(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher), "Title 2", "10:05"));
        data.add(new RecyclerData("Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3", ""));
        data.add(new RecyclerData("http://findicons.com/files/icons/367/ifunny/128/dog.png", "Title 4", ""));
        data.add(new RecyclerData(R.mipmap.ic_launcher, "Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1", "aaaaaaaaaaaa"));
        data.add(new RecyclerData(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher), "Title 2", "10:05"));
        data.add(new RecyclerData("Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3", ""));
        data.add(new RecyclerData("http://findicons.com/files/icons/367/ifunny/128/dog.png", "Title 4", ""));
        data.add(new RecyclerData(R.mipmap.ic_launcher, "Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1", "aaaaaaaaaaaa"));
        data.add(new RecyclerData(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher), "Title 2", "10:05"));
        data.add(new RecyclerData("Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3", ""));
        data.add(new RecyclerData("http://findicons.com/files/icons/367/ifunny/128/dog.png", "Title 4", ""));

        adapter = new CustomAdapter(this, data);
        ((RecyclerView) findViewById(R.id.recyclerView)).setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ((RecyclerView) findViewById(R.id.recyclerView)).setAdapter(adapter);
    }
}