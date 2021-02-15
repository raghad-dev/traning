package com.example.training;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class tot extends AppCompatActivity {

    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tot);

        btn2= findViewById(R.id.regester1);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(tot.this,singing.class);
                Bundle b = new Bundle();
                b.putString("form", "form2");
                intent2.putExtras(b);
                startActivity(intent2);
            }
        });
    }
}