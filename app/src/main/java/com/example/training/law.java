package com.example.training;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class law extends AppCompatActivity {

    private Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loww);

        btn5= findViewById(R.id.regester4);


        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(law.this,singing.class);
                Bundle b = new Bundle();
                b.putString("form", "form5");
                intent5.putExtras(b);
                startActivity(intent5);
            }
        });
    }
}