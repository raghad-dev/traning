package com.example.training;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class moni extends AppCompatActivity {
    RecyclerView mRecyclerView;
    adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moni);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new adapter(this, getMyList());
        mRecyclerView.setAdapter(adapter);
    }

    private ArrayList<Model> getMyList() {

        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("مهارات الاكسل المتقدمة");
        m.setImg(R.drawable.exxcel);
        models.add(m);


        //  m = new Model();
        //  m.setTitle("قدر ذاتك");
        //  m.setImg(R.drawable.des);
        //  models.add(m);


        // m = new Model();
        // m.setTitle("تدريب المدربين");
        // m.setImg(R.drawable.saf);
        // models.add(m);

        //m = new Model();
        //  m.setTitle("التسويق");
        // m.setImg(R.drawable.mar);
        //  models.add(m);

        return models;

    }
}