package com.example.tpf2i;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgGoogle,imgFacebook,imgApple;
    Button btnValider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // attacher les imageView

        imgGoogle = findViewById(R.id.google);
        imgFacebook = findViewById(R.id.facebook);
        imgApple = findViewById(R.id.apple);

        //attacher le button

        btnValider = findViewById(R.id.btnValider);

        //listener
        imgGoogle.setOnClickListener(v -> Toast.makeText(MainActivity.this,"Connected with Google ID",Toast.LENGTH_SHORT).show());

        imgFacebook.setOnClickListener(v -> Toast.makeText(MainActivity.this,"Connected with Facebook ID",Toast.LENGTH_SHORT).show());

        imgApple.setOnClickListener(v -> Toast.makeText(MainActivity.this,"Connected with Apple ID",Toast.LENGTH_SHORT).show());

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PersonnageActivity.class);
                startActivity(intent);
            }
        });
    }
}