/*  Remaining :- check whether the entred string is numeric or not */

package com.example.simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import simulator.R;

public class rc4Calculator extends AppCompatActivity {

    public EditText inputS;
    public EditText inputKey;
    public EditText inputPlain;
    public Button rc4Calculate;
    public TextView rc4Encrypt;
    public TextView rc4Decrypt;
    public Button rc4CalculateClear;

    public ArrayList<Integer> keyStep = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc4_calculator);

        inputS = findViewById(R.id.editText_rc4_s);
        inputKey = findViewById(R.id.editText_rc4_key);
        inputPlain = findViewById(R.id.editText_rc4_plain);
        rc4Encrypt = findViewById(R.id.encrypRc4Text);
        rc4Decrypt = findViewById(R.id.decrypRc4Text);
        rc4Calculate = findViewById(R.id.rc4Calculate);
        rc4CalculateClear = findViewById(R.id.rc4CalculateClear);

        rc4Calculate.setOnClickListener(view -> {

            String s1 = inputS.getText().toString();
            String k2 = inputKey.getText().toString();
            String pl = inputPlain.getText().toString();

            if(inputS.getText().toString().equals("") && inputKey.getText().toString().equals("") && inputPlain.getText().toString().equals("") ){
                inputS.setError("Text Fields cannot be empty");
                inputKey.setError("Text Fields cannot be empty");
                inputPlain.setError("Text Fields cannot be empty");

            }
            else if(inputS.getText().toString().equals("")){
                inputS.setError("Text Fields cannot be empty");

            }
            else if(inputKey.getText().toString().equals("")){
                inputKey.setError("Text Fields cannot be empty");

            }
            else if(inputPlain.getText().toString().equals("")){
                inputPlain.setError("Text Fields cannot be empty");

            }

            else {
                String[] s = s1.split(" ");
                String[] k;
                k = k2.split(" ");
                String[] plainText = pl.split(" ");
                int[] newKey = new int[k.length];

                int sLength = s.length;

                ArrayList<Integer> key = new ArrayList<>();

                  /*  If the key array length is smaller than s array length so to length same we have to repeat the elements
                        of key array until we get same length that of s array. */

                /*
                *   slength = 8
                    k[] = 4

                    quotient = 8 / 4 = 2
                    remainder = 8 % 4 = 0

                    *
                    slength = 10
                    k[] = 4

                    quotient = 10 / 4 = 2
                    remainder = 10 % 4 = 2


                * */

                if (sLength > k.length) {
                    int quotient = sLength / k.length;
                    int remainder = sLength % k.length;

                    while (quotient != 0) {
                        for (String value : k) {
                            key.add(Integer.parseInt(String.valueOf(value)));

                            // For Calculation of steps
                            keyStep.add(Integer.parseInt(String.valueOf(value)));

                        }
                        quotient--;
                    }

//                    Log.d("sarray", ""+s.toString());
                    for (int j = 0; j < remainder; j++) {
                        key.add(Integer.parseInt(String.valueOf(k[j])));

                        // For Calculation of Steps
                        keyStep.add(Integer.parseInt(String.valueOf(k[j])));

                    }
                }


                //Log.d("value of key", String.valueOf(key));

                /*  Step 1 :- Key-scheduling Algorithm */
                keyScheduling(s, sLength, key);

                /*  Step 2 :- Stream Generation */
                nayaKey(k.length, sLength, s, newKey);


                /*  Step 3 :- Encryption and Decryption */

                /*Encryption*/
                int[] p = rc4Encryption(plainText, newKey);
                rc4Encrypt.append("Encrypted Text :- ");
                for (int j : p) {
                    rc4Encrypt.append(" " + j);
                }

                /* Decryption */
                rc4Decrypt.append("Decrypted Text :- ");
                int[] o = rc4Decrypt(p, newKey);
                for (int j : o) {
                    rc4Decrypt.append(" " + j);
                }

            }
        });


        /* For Clean the Edittext and TextView */
        rc4CalculateClear.setOnClickListener(view -> {
                    inputS.getText().clear();
                    inputKey.getText().clear();
                    inputPlain.getText().clear();
                    rc4Encrypt.setText("");
                    rc4Decrypt.setText("");
        });



    }

    private int[] rc4Decrypt(int[] cipherText, int[] newKey) {
            int[] rc4PlainText = new int[newKey.length];

        for (int f=0; f< newKey.length && f<cipherText.length; f++){
            rc4PlainText[f] = cipherText[f] ^ newKey[f];

        }

        return rc4PlainText;
    }

    private int[] rc4Encryption(String[] plainText, int[] newKey) {
        int[] rc4CiperText = new int[newKey.length];

        for (int f=0; f< newKey.length && f<plainText.length; f++){
            //
            rc4CiperText[f] = Integer.parseInt(plainText[f]) ^ newKey[f];

        }

        return rc4CiperText;
    }

    private int[] nayaKey(int kLength, int sLength, String[] s, int[] newKey) {
        int r=0,e=0,y;


        for (int q=0; q<kLength; q++){

            r = (r+1) % sLength;
            e = (e + Integer.parseInt(s[r])) % sLength;
            swap(r, e, s);
            y = (Integer.parseInt(s[r]) + Integer.parseInt(s[e])) % sLength;
            newKey[q] = Integer.parseInt(s[y]);

        }
            return newKey;
    }


    private void keyScheduling(String[] s, int sLength, ArrayList<Integer> key) {
        int j=0;
        for(int i=0; i<sLength; i++){
            j = ((j + Integer.parseInt(s[i]) + key.get(i)) % sLength);
            swap(i, j, s);
        }
    }

    private void swap(int i, int j, String[] s) {
        String temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


}