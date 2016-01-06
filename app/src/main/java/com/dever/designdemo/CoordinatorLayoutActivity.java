package com.dever.designdemo;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("hahaha"+i);
        }
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView.setAdapter(new MyAdapter(this, list));
        findViewById(R.id.btn).setOnClickListener(this);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(coordinatorLayout,"hahahahaha",Snackbar.LENGTH_SHORT).show();
    }
}
