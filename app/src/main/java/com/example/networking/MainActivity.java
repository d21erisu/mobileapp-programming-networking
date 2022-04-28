package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private RecyclerView recyclerView;

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> mountains = Arrays.asList("Test", "Test2");
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView = findViewById(R.id.recycler_view);
        MountainAdapter mountainAdapter = new MountainAdapter(mountains);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        new JsonFile(this, this).execute(JSON_FILE);

        new JsonTask(this).execute(JSON_URL);


    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
    }

}
