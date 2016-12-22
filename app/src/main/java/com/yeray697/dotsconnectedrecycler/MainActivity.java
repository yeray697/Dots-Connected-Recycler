package com.yeray697.dotsconnectedrecycler;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.yeray697.dotLineRecyclerView.DotLineRecyclerAdapter;
import com.yeray697.dotLineRecyclerView.DotLineRecyclerView;
import com.yeray697.dotLineRecyclerView.DotView;
import com.yeray697.dotLineRecyclerView.Message_View;
import com.yeray697.dotLineRecyclerView.RecyclerData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DotLineRecyclerAdapter adapter;
    ArrayList<RecyclerData> data;
    DotLineRecyclerView recyclerView;
    ArrayList<Integer> colorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();
        data.add(new RecyclerData(R.mipmap.ic_launcher, "Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1", "aaaaaaaaaaaa",0));
        data.add(new RecyclerData(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher), "Title 2", "10:05",1));
        data.add(new RecyclerData("Title 3", "10:05",2));
        data.add(new RecyclerData(R.mipmap.ic_launcher, "Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1", "aaaaaaaaaaaa",3));
        data.add(new RecyclerData(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher), "Title 2", "10:05",1));
        data.add(new RecyclerData("Title 3", "10:05"));

        colorList = new ArrayList<>();
        colorList.add(Color.RED);
        colorList.add(Color.CYAN);
        colorList.add(Color.YELLOW);
        colorList.add(Color.GREEN);

        adapter = new CustomAdapter(data,colorList);
        adapter.setOnImageClickListener(new DotLineRecyclerAdapter.OnImageClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Short click: Image", Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnImageLongClickListener(new DotLineRecyclerAdapter.OnImageLongClickListener() {
            @Override
            public boolean onClick(View v) {
                Toast.makeText(MainActivity.this, "Long click: Image", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        adapter.setOnDotLongClickListener(new DotView.OnDotLongClickListener() {
            @Override
            public boolean onClick(View v) {
                Toast.makeText(MainActivity.this, "Long click: Dot", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        adapter.setOnDotClickListener(new DotView.OnDotClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Short click: Dot", Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnMessageClickListener(new Message_View.OnMessageClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Short click: Message", Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnMessageLongClickListener(new Message_View.OnMessageLongClickListener() {
            @Override
            public boolean onClick(View v) {
                Toast.makeText(MainActivity.this, "Long click: Message", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        recyclerView = ((DotLineRecyclerView) findViewById(R.id.recyclerView));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setLineColor(Color.GRAY);
        recyclerView.setLineWidth(2);
    }
}