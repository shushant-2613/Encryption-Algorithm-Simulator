package com.example.simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import simulator.R;

public class rc4_theory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc4_theory);

//          First RC4 image zoom code
        findViewById(R.id.firstRc4ImageId).setOnClickListener(view -> {
            Intent intent = new Intent(rc4_theory.this, imageZoom.class);
            intent.putExtra("my_image", R.drawable.first_rc4);
            startActivity(intent);
        });

//        Second RC4 image zoom
        findViewById(R.id.secondRc4ImageId).setOnClickListener(view -> {
            Intent intent = new Intent(rc4_theory.this, imageZoom.class);
            intent.putExtra("my_image", R.drawable.second_rc4);
            startActivity(intent);
        });


//        Third RC4 image zoom
        findViewById(R.id.thirdRc4ImageId).setOnClickListener(view -> {
            Intent intent = new Intent(rc4_theory.this, imageZoom.class);
            intent.putExtra("my_image", R.drawable.third_rc4);
            startActivity(intent);
        });

        findViewById(R.id.rc4_xor).setOnClickListener(view -> {
            Intent intent = new Intent(rc4_theory.this, imageZoom.class);
            intent.putExtra("my_image", R.drawable.fourth_rc4);
            startActivity(intent);
        });




        findViewById(R.id.rc4SimulationBtn).setOnClickListener(view -> {
            openRc4Calculator();
            Toast.makeText(this, "RC4 calculator is Open", Toast.LENGTH_SHORT).show();
        });

    }

    private void openRc4Calculator() {
        Intent intentRc4Calculator = new Intent(this, rc4Calculator.class);
        startActivity(intentRc4Calculator);
    }
}