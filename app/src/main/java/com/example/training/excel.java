package com.example.training;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class excel extends AppCompatActivity {
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excel);


        btn4= findViewById(R.id.regester3);


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(excel.this,singing.class);
                Bundle b = new Bundle();
                b.putString("form", "form4");
                intent4.putExtras(b);
                startActivity(intent4);
            }
        });

    }
}


