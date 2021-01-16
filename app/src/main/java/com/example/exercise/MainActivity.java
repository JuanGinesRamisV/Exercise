package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarListView();
    }

    private void inicializarListView(){
        this.listView= findViewById(R.id.list_view);
        this.arrayList= new ArrayList<>();
        this.arrayList.add("first exercise");
        this.arrayList.add("Task 1,2,3 editText");
        this.arrayList.add("Task 4,5 alert and time pickers");
        this.arrayList.add("Task 6 droid desserts");
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  this.arrayList);
        this.listView.setAdapter(adapter);
        this.listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        System.out.println("hjere");
        if (this.adapter.equals(adapterView.getAdapter())){
            switch (i){
                case 0:
                    Intent intent = new Intent(getApplicationContext(), FirstExercise.class);
                    startActivity(intent);
                    break;
                case 1:
                    Intent intent1 = new Intent(getApplicationContext(), InputControls.class);
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(getApplicationContext(),AlertDataPickers.class);
                    startActivity(intent2);
                    break;
                case 3:
                    Intent intent3 = new Intent(getApplicationContext(),DroidCafe.class);
                    startActivity(intent3);
            }
        }
    }
}