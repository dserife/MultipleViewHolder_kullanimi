package com.example.multipleviewholder_kullanimi.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.multipleviewholder_kullanimi.Adapter.RecyclerViewAdapter;
import com.example.multipleviewholder_kullanimi.Model.Kisi;
import com.example.multipleviewholder_kullanimi.Model.Reklam;
import com.example.multipleviewholder_kullanimi.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    List<Object> objects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        objects = new ArrayList<>();
        objects.add(new Kisi(R.drawable.user1,20,"Ad Soyad 1"));
        objects.add(new Kisi(R.drawable.user2,20,"Ad Soyad 2"));
        objects.add(new Reklam("12345"));
        objects.add(new Kisi(R.drawable.user1,25,"Ad Soyad 3"));
        objects.add(new Kisi(R.drawable.user2,29,"Ad Soyad 4"));

        adapter = new RecyclerViewAdapter(objects,getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }
}
