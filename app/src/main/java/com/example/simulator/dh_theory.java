package com.example.simulator;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Locale;

import simulator.R;

public class dh_theory extends AppCompatActivity {


    private ImageView speakImage;
    private ImageView diffieImage;
    private TextView text;
    private TextToSpeech speakText;
    private Button diffieCalculator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dh_theory);

        speakImage = findViewById(R.id.id_speak);
        diffieImage = findViewById(R.id.id_diffie_hellman);
        text = findViewById(R.id.dh_text);
        diffieCalculator = findViewById(R.id.diffie_calculator);

        diffieImage.setOnClickListener(view -> {
            Intent intent = new Intent(dh_theory.this, imageZoom.class);
            intent.putExtra("my_image", R.drawable.diffie_hellman);
            startActivity(intent);
        });

        speakImage.setOnClickListener(view ->  {


                speakText = new TextToSpeech(getApplicationContext(), i -> {
                    if(i==TextToSpeech.SUCCESS){
                        speakText.setLanguage(Locale.ENGLISH);
                        speakText.setSpeechRate(1.0f);
                        speakText.speak(text.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                    }
                });


        });

        diffieCalculator.setOnClickListener(view ->  {

                openDiffieCalculator();

        });
    }


    public void openDiffieCalculator() {
        Intent intent = new Intent(this, diffieCalculator.class);
        startActivity(intent);
    }
}