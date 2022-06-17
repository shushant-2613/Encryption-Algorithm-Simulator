package com.example.simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

import simulator.R;

public class diffieCalculator extends AppCompatActivity {

    public static EditText g;
    public static EditText n;
    public static EditText x;
    public static EditText y;
    private TextView k1edit;
    private TextView k2edit;
    public int temp = 0;
    public static BigInteger A,B,K1,K2, at1, at2, at3, at4, bt1, bt2, bt3, bt4, k1t1, k1t2, k1t3, k1t4, k2t1, k2t2, k2t3, k2t4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diffie_calculator);

        g = findViewById(R.id.editText_diffie_g);
        n = findViewById(R.id.editText_diffie_n);
        x = findViewById(R.id.editText_diffie_x);
        y = findViewById(R.id.editText_diffie_y);
        k1edit = findViewById(R.id.editText_diffie_k1);
        k2edit = findViewById(R.id.editText_diffie_k2);
        Button calculate = findViewById(R.id.diffie_calculate_calculate);
        Button clear = findViewById(R.id.diffie_calculate_clear);
        Button diffie_steps = findViewById(R.id.diffie_calculate_step);



        calculate.setOnClickListener(view ->  {


                if (g.getText().toString().equals("") && n.getText().toString().equals("") && x.getText().toString().equals("") && y.getText().toString().equals("")) {
                    g.setError("Text Fields cannot be empty");
                    n.setError("Text Fields cannot be empty");
                    x.setError("Text Fields cannot be empty");
                    y.setError("Text Fields cannot be empty");
                    temp++;
                } else if (g.getText().toString().equals("")) {
                    g.setError("Text Fields cannot be empty");
                    temp++;
                } else if (n.getText().toString().equals("")) {
                    n.setError("Text Fields cannot be empty");
                    temp++;
                } else if (x.getText().toString().equals("")) {
                    x.setError("Text Fields cannot be empty");
                    temp++;
                } else if (y.getText().toString().equals("")) {
                    y.setError("Text Fields cannot be empty");
                    temp++;
                } else {


                    A = BigInteger.valueOf(Long.parseLong(g.getText().toString())).modPow(BigInteger.valueOf(Long.parseLong(x.getText().toString())),
                            BigInteger.valueOf(Long.parseLong(n.getText().toString())));

                    at1 = BigInteger.valueOf(Long.parseLong(g.getText().toString()));
                    at2 = BigInteger.valueOf(Long.parseLong(x.getText().toString()));
                    at3 = at1.modPow(at2, BigInteger.valueOf(Long.parseLong("100000004777")));
                    at4 = at3.mod(BigInteger.valueOf(Long.parseLong(n.getText().toString())));


                    B = BigInteger.valueOf(Long.parseLong(g.getText().toString())).modPow(BigInteger.valueOf(Long.parseLong(y.getText().toString())),
                            BigInteger.valueOf(Long.parseLong(n.getText().toString())));

                    bt1 = BigInteger.valueOf(Long.parseLong(g.getText().toString()));
                    bt2 = BigInteger.valueOf(Long.parseLong(y.getText().toString()));
                    bt3 = bt1.modPow(bt2, BigInteger.valueOf(Long.parseLong("100000004777")));
                    bt4 = bt3.mod(BigInteger.valueOf(Long.parseLong(n.getText().toString())));


                    K1 = B.modPow(new BigInteger(x.getText().toString()), new BigInteger(n.getText().toString()));

                    k1t1 = B;
                    k1t2 = BigInteger.valueOf(Long.parseLong(x.getText().toString()));
                    k1t3 = k1t1.modPow(k1t2, BigInteger.valueOf(Long.parseLong("100000004777")));
                    k1t4 = k1t3.mod(BigInteger.valueOf(Long.parseLong(n.getText().toString())));


                    K2 = A.modPow(new BigInteger(y.getText().toString()), new BigInteger(n.getText().toString()));

                    k2t1 = A;
                    k2t2 = BigInteger.valueOf(Long.parseLong(y.getText().toString()));
                    k2t3 = k2t1.modPow(k2t2, BigInteger.valueOf(Long.parseLong("100000004777")));
                    k2t4 = k2t3.mod(BigInteger.valueOf(Long.parseLong(n.getText().toString())));


                    k1edit.setText("First Key : " + K1);
                    k2edit.setText("Second Key : " + K2);

                    int comparevalue = K1.compareTo(K2);

                    if (comparevalue == 0) {
                        Toast.makeText(diffieCalculator.this, "Diffie Hellman Algorithm is verified", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(diffieCalculator.this, "Diffie Hellman Algorithm is not verified", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        diffie_steps.setOnClickListener(view -> {
            if(g.getText().toString().equals("") && n.getText().toString().equals("") && x.getText().toString().equals("") && y.getText().toString().equals("")){
                g.setError("Text Fields cannot be empty");
                n.setError("Text Fields cannot be empty");
                x.setError("Text Fields cannot be empty");
                y.setError("Text Fields cannot be empty");
                temp++;
            }
            else if(g.getText().toString().equals("")){
                g.setError("Text Fields cannot be empty");
                temp++;
            }
            else if(n.getText().toString().equals("")){
                n.setError("Text Fields cannot be empty");
                temp++;
            }
            else if(x.getText().toString().equals("")){
                x.setError("Text Fields cannot be empty");
                temp++;
            }
            else if(y.getText().toString().equals("")){
                y.setError("Text Fields cannot be empty");
                temp++;
            }
            else {
                Intent it = new Intent(diffieCalculator.this, diffieCalculatorSteps.class);
                startActivity(it);
            }
        });


        clear.setOnClickListener(view -> {
            g.getText().clear();
            n.getText().clear();
            x.getText().clear();
            y.getText().clear();

            k1edit.setText("");
            k2edit.setText("");
        });
    }
}