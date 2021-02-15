package com.example.training;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class your extends AppCompatActivity {

    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your);
        btn3= findViewById(R.id.regester2);


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(your.this,singing.class);
                Bundle b = new Bundle();
                b.putString("form", "form3");
                intent3.putExtras(b);
                startActivity(intent3);
            }
        });

    }
}