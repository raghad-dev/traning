package com.example.training;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class photo extends AppCompatActivity {

    private Button btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);


        btn6= findViewById(R.id.regester5);


        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(photo.this,singing.class);
                Bundle b = new Bundle();
                b.putString("form", "form6");
                intent6.putExtras(b);
                startActivity(intent6);
            }
        });

    }
}






