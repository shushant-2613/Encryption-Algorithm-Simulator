package com.example.simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import simulator.R;

public class firstPage extends AppCompatActivity {

    private Button dh;
    private Button rsa;
    private Button rc4;
    private Button vigenere;
    private VideoView videoBG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);


        dh = findViewById(R.id.dh_btn);
        rsa = findViewById(R.id.rsa_btn);
        rc4 = findViewById(R.id.rc4_btn);
        vigenere = findViewById(R.id.Vigener_btn);

        rsa.setOnClickListener(view -> {

                openRsaTheory();

                Toast toast = Toast.makeText(firstPage.this, "Rsa is opened", Toast.LENGTH_SHORT);
                toast.show();

        });


        dh.setOnClickListener(view ->  {

                openDhTheory();

                Toast toast = Toast.makeText(firstPage.this, "Diffie Hellman is opened", Toast.LENGTH_SHORT);
                toast.show();

        });

        rc4.setOnClickListener(view -> {
            openRc4();

            Toast toast = Toast.makeText(firstPage.this, "RC4 is opened", Toast.LENGTH_SHORT);
            toast.show();
        });

        vigenere.setOnClickListener(view -> {
            openVigenere();

            Toast toast = Toast.makeText(firstPage.this, "Vigenere is opened", Toast.LENGTH_SHORT);
            toast.show();
        });
    }


    private void openVigenere() {
        Intent intentVigenere = new Intent(this, vigenere_theory.class);
        startActivity(intentVigenere);
    }

    private void openRc4() {
        Intent intentRc4 = new Intent(this, rc4_theory.class);
        startActivity(intentRc4);
    }

    private void openRsaTheory() {
        Intent intentRsa = new Intent(this,rsa_theory.class);
        startActivity(intentRsa);
    }

    private void openDhTheory(){
        Intent intent = new Intent(this, dh_theory.class);
        startActivity(intent);
    }
}
