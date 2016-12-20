package com.yeray697.dotsconnectedrecycler;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CustomAdapter adapter;
    ArrayList<RecyclerData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //La activity que hay que tocar es recycler_item.xml

        //Estos son los elementos que se muestran en la lista
        //Funcionan todos bien en el caso de pasarle un subtitulo que ocupe menos de una línea
        //Si ocupa más, aún teniendo el subtítulo below al título lo transpasa.
        //Si se quita 'android:layout_centerVertical="true"' funciona bien.
        //Con la preview azul de la activity se ve que el tvSubtitle no cambia de sitio al cambiar centerVertical del título,
        //      es como si el titulo siguiese arriba aunque esté en el centro
        data = new ArrayList<>();
        data.add(new RecyclerData(R.mipmap.ic_launcher, "Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1Title1", "aaaaaaaaaaaa"));
        data.add(new RecyclerData(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.ic_launcher), "Title 2", "10:05"));

        data.add(new RecyclerData("Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3Title 3", "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"));
        data.add(new RecyclerData("http://findicons.com/files/icons/367/ifunny/128/dog.png", "Title 4", "ddddddddddddddddddddd"));

        adapter = new CustomAdapter(data);
        ((RecyclerView) findViewById(R.id.recyclerView)).setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ((RecyclerView) findViewById(R.id.recyclerView)).setAdapter(adapter);
    }
}