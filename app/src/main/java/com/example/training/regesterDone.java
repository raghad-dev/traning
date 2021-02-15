package com.example.training;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class regesterDone extends AppCompatActivity {
private Button btn0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_regester_done );

        btn0= findViewById(R.id.btn0);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(regesterDone.this,subpage_Training.class);
                startActivity(intent0);
            }
        });
    }
}