package com.example.simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import simulator.R;

public class vigenere_theory extends AppCompatActivity {
    private Button vigenereSimulate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigenere_theory);


        findViewById(R.id.VigenereEncryprion).setOnClickListener(view -> {
            Intent intent = new Intent(vigenere_theory.this, imageZoom.class);
            intent.putExtra("my_image", R.drawable.vigenereencryption);
            startActivity(intent);
        });


        findViewById(R.id.VigenereDecryprion).setOnClickListener(view -> {
            Intent intent = new Intent(vigenere_theory.this, imageZoom.class);
            intent.putExtra("my_image", R.drawable.vigeneredecryption);
            startActivity(intent);
        });

        findViewById(R.id.id_diffie_hellman).setOnClickListener(view -> {
            Intent intent = new Intent(vigenere_theory.this, imageZoom.class);
            intent.putExtra("my_image", R.drawable.firstvigenereimg);
            startActivity(intent);
        });





        vigenereSimulate = findViewById(R.id.vigenere_simulator_btn);

        vigenereSimulate.setOnClickListener(view -> {
            Intent vigenereSimulateIntend = new Intent(this, vigenereCalculator.class);
            startActivity(vigenereSimulateIntend);
        });
    }
}