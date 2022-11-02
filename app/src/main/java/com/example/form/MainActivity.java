package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.form.FormActivity;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    ListView formlistview;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button form = findViewById(R.id.button_form);
        formlistview = findViewById(R.id.list);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);

        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });
       formlistview.setAdapter(arrayAdapter);
       Intent listintent = getIntent();
       String liststr = listintent.getStringExtra("Name");
       arrayList.add(liststr);
       arrayAdapter.notifyDataSetChanged();
    }
}
