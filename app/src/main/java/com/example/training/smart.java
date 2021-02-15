package com.example.training;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


public class smart extends AppCompatActivity{

private Button btn1;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart);

    btn1= findViewById(R.id.regester);


    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(smart.this,singing.class);
            Bundle b = new Bundle();
            b.putString("form", "form1");
            intent1.putExtras(b);
            startActivity(intent1);
        }
    });

    }


}