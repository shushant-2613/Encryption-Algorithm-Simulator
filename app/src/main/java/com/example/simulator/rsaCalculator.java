package com.example.simulator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;
import java.util.ArrayList;

import simulator.R;

public class rsaCalculator extends AppCompatActivity {

    public static EditText p;
    public static EditText q;
    public static EditText e;
    public static EditText pt;
    public TextView encrypRsaText;
    public TextView decrypRsaText;
    private Button rsaCalculate;
    public static BigInteger N;
    public static BigInteger phiN;
    public static BigInteger d;
    public static BigInteger finalCt;
    public static BigInteger finalPt;
    private Button rsaStep;
    private Button rsaClear;
    public int temp=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsa_calculator);

        p = findViewById(R.id.editText_rsa_p);
        q = findViewById(R.id.editText_rsa_q);
        e = findViewById(R.id.editText_rsa_e);
        pt = findViewById(R.id.editText_rsa_plain);
        encrypRsaText = findViewById(R.id.encrypRsaText);
        decrypRsaText = findViewById(R.id.decrypRsaText);
        rsaCalculate = findViewById(R.id.rsaCalculate);
        rsaStep = findViewById(R.id.rsaStep);
        rsaClear = findViewById(R.id.rsaClean);

        rsaCalculate.setOnClickListener(view -> {

            if(p.getText().toString().equals("") && q.getText().toString().equals("") && e.getText().toString().equals("") && pt.getText().toString().equals("")){
                p.setError("Text Fields cannot be empty");
                q.setError("Text Fields cannot be empty");
                e.setError("Text Fields cannot be empty");
                pt.setError("Text Fields cannot be empty");

            }
            else if(p.getText().toString().equals("")){
                p.setError("Text Fields cannot be empty");

            }
            else if(q.getText().toString().equals("")){
                q.setError("Text Fields cannot be empty");

            }
            else if(e.getText().toString().equals("")) {
                e.setError("Text Fields cannot be empty");
            }

            else if(pt.getText().toString().equals("")){
                pt.setError("Text Fields cannot be empty");

            }
            else {


                //Multiplication of N = p * q;
                N = BigInteger.valueOf(Long.parseLong(p.getText().toString())).multiply(BigInteger.valueOf(Long.parseLong(q.getText().toString())));

                //phiN = (p-1) * (q-1)
                phiN = BigInteger.valueOf((int) (Long.parseLong(p.getText().toString())) - 1).multiply(BigInteger.valueOf((int) (Long.parseLong(q.getText().toString())) - 1));

                //Generation of Decryption key d
                d = decryptionKey(phiN, BigInteger.valueOf(Long.parseLong(e.getText().toString())));

                //Generation of cipher Text by calling method cipherText()
                finalCt = cipherText(BigInteger.valueOf(Long.parseLong(pt.getText().toString())), BigInteger.valueOf(Long.parseLong(e.getText().toString())), N);

                //Generation of plain Text by calling method plainText()
                finalPt = plainText(finalCt, d, N);

                //Setting the encryption text in textView.
                encrypRsaText.setText(String.valueOf(finalCt));

                //Setting the decryption text in textView.
                decrypRsaText.setText(String.valueOf(finalPt));

                if (String.valueOf(finalPt).equals(pt.getText().toString())) {
                    Toast.makeText(this, "Plain text and decrypted hence RSA simulator is verified", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "RSA simulator is not verified", Toast.LENGTH_SHORT).show();
                }
            }
        });



            rsaStep.setOnClickListener(view -> {

                if(p.getText().toString().equals("") && q.getText().toString().equals("") && e.getText().toString().equals("") && pt.getText().toString().equals("")){
                    p.setError("Text Fields cannot be empty");
                    q.setError("Text Fields cannot be empty");
                    e.setError("Text Fields cannot be empty");
                    pt.setError("Text Fields cannot be empty");

                }
                else if(p.getText().toString().equals("")){
                    p.setError("Text Fields cannot be empty");

                }
                else if(q.getText().toString().equals("")){
                    q.setError("Text Fields cannot be empty");

                }
                else if(e.getText().toString().equals("")){
                    e.setError("Text Fields cannot be empty");

                }
                else if(pt.getText().toString().equals("")){
                    pt.setError("Text Fields cannot be empty");

                }
                else{
                    Intent rsaStepIntend = new Intent(this, rsaCalculateStep.class);
                    startActivity(rsaStepIntend);
                }
            });




        rsaClear.setOnClickListener(view -> {
            p.getText().clear();
            q.getText().clear();
            e.getText().clear();
            pt.getText().clear();

            encrypRsaText.setText("");
            decrypRsaText.setText("");

            dStep.clear();
        });


    }


//    Decryption key Generation
    public static  ArrayList<BigInteger> dStep = new ArrayList<>();

   private static BigInteger decryptionKey(BigInteger phiN, BigInteger e){
        BigInteger r ,d1=BigInteger.valueOf(0), d2 = BigInteger.valueOf(0);

        for (int i=1; i<10e5; i++){

            /*For Calcuation decryption key by using formula d = ((i * phiN) + 1) / e
                if the value of d will be integer then and then only we will consider or else increase the value of i.
                for calculating this we use below formula
            */

            //u = (i * phiN) + 1
            BigInteger u = (BigInteger.valueOf(i).multiply(phiN) ).add( BigInteger.valueOf(1) );

            //r = u % e
            r = u.mod(e) ;

            /* if we get value of r is equal to zero then we will consider it. or else we will increase the value of i*/
            if(r.equals(d2)){

                 d1 = u.divide(e);
                 dStep.add(u);
                break;
            }

            //in each and every iteration the value of d is stored in arraylist dStep for calculation of steps
            dStep.add(u);

        }

        return d1;
    }

//    Generation of cipher Text.

    private static BigInteger cipherText(BigInteger pt, BigInteger e, BigInteger N){
        BigInteger ct;

        //calculation of cipher using the formula ct = (pt^e)%N
        /*we have inbuilt function in biginteger that ct = pt.modPow(e,N)*/
        ct = pt.modPow(e, N);
        return ct;
    }


//    Generation of Plain Text.
    private static BigInteger plainText(BigInteger ct, BigInteger d, BigInteger N){
        BigInteger pt;

        //calculation of plain using the formula pt = (ct^e)%N
        /*we have inbuilt function in biginteger that pt = ct.modPow(e,N)*/
        pt = ct.modPow(d, N);
        return pt;
    }






}