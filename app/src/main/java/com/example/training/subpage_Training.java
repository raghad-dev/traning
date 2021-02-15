package com.example.training;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class subpage_Training extends AppCompatActivity implements View.OnClickListener {

    public CardView card1,card2,card3,card4,card5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subpage__training);

        card1=(CardView) findViewById(R.id.computer);
        card2=(CardView) findViewById(R.id.des);
        card3=(CardView) findViewById(R.id.saf);
        card4=(CardView) findViewById(R.id.mar);
        card5=(CardView) findViewById(R.id.low);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {

            case R.id.computer:
                i = new Intent(this,computer.class);
                startActivity(i);
                break;

            case R.id.des:
                i = new Intent(this,des.class);
                startActivity(i);
                break;

            case R.id.saf:
                i = new Intent(this,sec.class);
                startActivity(i);
                break;

            case R.id.mar:
                i = new Intent(this,moni.class);
                startActivity(i);
                break;

            case R.id.low:
                i = new Intent(this,low.class);
                startActivity(i);
                break;


        }
    }
}