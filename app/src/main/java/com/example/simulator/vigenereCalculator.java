package com.example.simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

import simulator.R;

public class vigenereCalculator extends AppCompatActivity {

    public static EditText vPlainText;
    public static EditText vKeyText;
    public TextView vEncryptText;
    public TextView vDecryptText;
    public Button vCalculate;
    public Button vSteps;
    public Button vClear;
    public static String Str;
    public static String Keyword;
    public static String key;   //this is for new key
    public static LinkedList<Character> cpLink = new LinkedList<>();
    public static LinkedList<Character> ptLink = new LinkedList<>();
    public static ArrayList<Integer> dl = new ArrayList<>();
    public static ArrayList<String> ctStep = new ArrayList<>();
    public static ArrayList<String> otStep = new ArrayList<>();
    public static int t ;
    public static int clean;
    public String finalCipherText = "";
    public  String finalOriginalText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigenere_calculator);

        vPlainText = findViewById(R.id.vigenerePlainText);
        vKeyText = findViewById(R.id.editText_rsa_q);
        vEncryptText = findViewById(R.id.vigenereEncrypt);
        vDecryptText = findViewById(R.id.vigenereDecrypt);
        vCalculate = findViewById(R.id.vigenereCalculateBtn);
        vSteps = findViewById(R.id.vigenereStepBtn);
        vClear = findViewById(R.id.vigenereCleanBtn);

        vCalculate.setOnClickListener(view -> {

            Str = vPlainText.getText().toString();
            Keyword = vKeyText.getText().toString();

            if(Str.equals("") && Keyword.equals("")){
                vPlainText.setError("Text Fields cannot be empty");
                vKeyText.setError("Text Fields cannot be empty");

            }
            else if(vPlainText.getText().toString().equals("")){
                vPlainText.setError("Text Fields cannot be empty");

            }
            else if(vKeyText.getText().toString().equals("")){
                vKeyText.setError("Text Fields cannot be empty");

            }



          else {
             t=0;
             // Adding location of space from given string in arraylist

                /*
                 for explanation consider example
                    plain text = i am shushant
                    key = example

                    str = plain text
                    str.length() = 13
                    key.length() = 7

                 */
                //in the plain text there is space at index 1 and 4. so that we have store the value 1 and 4 in arraylist.
                for (int i = 0; i < Str.length(); i++) {
                    if (Str.charAt(i) == ' ') {
                        dl.add(i);
                    }
                }


                String[] a = Str.split(" ");
                //a[] = {I,am,shushant};

                // Removing space in between the string
                StringBuilder Str1 = new StringBuilder();
                for (int i = 0; i < a.length; i++) {
                    Str1.append(a[i]);
                }
                //str1 = Iamshushant

                String str = LowerToUpper(Str1.toString());
                String keyword = LowerToUpper(Keyword);

                key = generateKey(str, keyword);
                String cipher_text = cipherText(str, key);

//          Adding space to the Cipher text

                char[] cpchar = cipher_text.toCharArray();
                //cpchar[] = {MXMEWFWLXMF}

                for (char c : cpchar) {
                    cpLink.add(c);
                }

//                cpLink = {MXMEWFWLXMF};

                //Adding space between the cipher text
                for (int i = 0; ; i++) {
                    if (i < dl.size()) {

                        cpLink.add(dl.get(i), ' ');
                    } else {
                        break;
                    }

                }

                /*In 1st iteration
                because in arraylist dl we have 1
                    cpLink = {M XMEWFWLXMF}

                  in 2nd iteration
                  because in arraylist dl we have 4
                    cpLink = {M XM EWFWLXMF}
                * */


                for (int i = 0; i < cpLink.size(); i++) {
                    finalCipherText += cpLink.get(i);
                }


                vEncryptText.setText("Encrypted Text :- "+finalCipherText);


                //Adding space to original text
                String original_text = originalText(cipher_text, key);


                char[] ptchar = original_text.toCharArray();


                for (char c : ptchar) {
                    ptLink.add(c);
                }

                for (int i = 0; ; i++) {
                    if (i < dl.size()) {

                        ptLink.add(dl.get(i), ' ');
                    } else {
                        break;
                    }

                }



                for (int i = 0; i < ptLink.size(); i++) {
                    finalOriginalText += ptLink.get(i);
                }


                vDecryptText.setText("Decrypted Text :- "+finalOriginalText);


            }

          });


            vSteps.setOnClickListener(view -> {

                if(Str.equals("") && Keyword.equals("")){
                    vPlainText.setError("Text Fields cannot be empty");
                    vKeyText.setError("Text Fields cannot be empty");

                }
                else if(vPlainText.getText().toString().equals("")){
                    vPlainText.setError("Text Fields cannot be empty");

                }
                else if(vKeyText.getText().toString().equals("")){
                    vKeyText.setError("Text Fields cannot be empty");

                }
                else {
                    Intent vigenereStepIntent = new Intent(this, vigenereCalculateStep.class);
                    startActivity(vigenereStepIntent);
                }
            });


        vClear.setOnClickListener(view -> {
            vPlainText.getText().clear();
            vKeyText.getText().clear();
            vEncryptText.setText("");
            vDecryptText.setText("");

            finalCipherText = " ";
            finalOriginalText = " ";
            cpLink.clear();
            ptLink.clear();
            dl.clear();
            ctStep.clear();
            otStep.clear();


        });

    }



//    Lower to Upper Case
    static String LowerToUpper(String s)
    {
        StringBuilder str =new StringBuilder(s);
        for(int i = 0; i < s.length(); i++)
        {
            if(Character.isLowerCase(s.charAt(i)))
            {
                str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
        s = str.toString();
        return s;
    }


//    Original Text
    static String originalText(String cipher_text, String key)
    {
        String orig_text="";

        for (int i = 0 ; i < cipher_text.length() &&
                i < key.length(); i++)
        {
            // converting in range 0-25
            int x = (cipher_text.charAt(i) -
                    key.charAt(i) + 26) %26;

            // convert into alphabets(ASCII)
            x += 'A';

            orig_text+=(char)(x);

            //Adding values in array of each iteration for steps

            otStep.add(orig_text);
        }
        return orig_text;
    }

// Generation of new Key if the length of key is less than the plain text length
    static String generateKey(String str, String key)
    {
        int x = str.length();

        StringBuilder keyBuilder = new StringBuilder(key);
        for (int i = 0; ; i++)
        {
            if (x == i)
                i = 0;
            if (keyBuilder.length() == str.length())
                break;
            keyBuilder.append(keyBuilder.charAt(i));

        }
        key = keyBuilder.toString();
        return key;
    }




// Generation of cipher text
    static String cipherText(String str, String key)
    {
        String cipher_text="";

        for (int i = 0; i < str.length(); i++)
        {
            // converting in range 0-25
            int x = (str.charAt(i) + key.charAt(i)) %26;

            // convert into alphabets(ASCII)
            x += 'A';

            cipher_text+=(char)(x);


            //Adding values in array of each iteration for steps

            ctStep.add(cipher_text);
        }
        return cipher_text;
    }
}