package com.example.training;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class safety extends AppCompatActivity {


    private Button btn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safty);

        btn7= findViewById(R.id.regester6);


        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(safety.this,singing.class);
                Bundle b = new Bundle();
                b.putString("form", "form7");
                intent7.putExtras(b);
                startActivity(intent7);
            }
        });



    }
}


