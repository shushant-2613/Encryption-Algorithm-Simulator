package com.example.simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import simulator.R;

public class rsa_theory extends AppCompatActivity {

    /* Below is the longest form of onclicklistener */
    //    private Button rsaCalcualtorBtn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_rsa_theory);
//
//        rsaCalcualtorBtn = findViewById(R.id.rsaCalculatorBtn);
//
//        rsaCalcualtorBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////             code ___________________
//            }
//        });
//    }

    /* Below is the shortest form of onclicklistener */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsa_theory);


        findViewById(R.id.rsaSimulationBtn).setOnClickListener(view  -> {
            openRsaCalculator();
            Toast toast = Toast.makeText(this, "RSA Calculator is opened", Toast.LENGTH_SHORT);
            toast.show();
        });


    }

    private void openRsaCalculator() {
        Intent intentRsaCalculator = new Intent(this, rsaCalculator.class);
        startActivity(intentRsaCalculator);
    }
}