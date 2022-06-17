package com.example.simulator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import simulator.R;

public class vigenereCalculateStep extends AppCompatActivity {

    public static TextView pTextStep;
    public static TextView keyTextStep;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigenere_calculate_step);

        pTextStep = findViewById(R.id.pTextVigenere);
        keyTextStep = findViewById(R.id.keyTextVigenere);

        if(vigenereCalculator.clean == 1){
            vigenereCalculateStep.pTextStep.setText(" ");
            vigenereCalculateStep.keyTextStep.setText(" ");
        }
        else{
            VigStep.displayVigStep();
        }

    }
}



class VigStep extends vigenereCalculator{
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void displayVigStep(){

        //        Given
        String g = "<b> Given </b>";
        vigenereCalculateStep.pTextStep.append(Html.fromHtml(g));
        vigenereCalculateStep.pTextStep.append("\t\t:-\t\t");
        vigenereCalculateStep.pTextStep.append("plain Text = " + vPlainText.getText().toString()+"\n");
        vigenereCalculateStep.pTextStep.append("                Key = " + vKeyText.getText().toString()+"\n");


//      Creation of key if key length is less than plain text length.
       if(vigenereCalculator.Str.length() == vigenereCalculator.Keyword.length()){
           String step1 = "<b> Step 1 : </b>";
           vigenereCalculateStep.keyTextStep.append(Html.fromHtml(step1));
           vigenereCalculateStep.keyTextStep.append("Key Generation \n\n\t\t");
           vigenereCalculateStep.keyTextStep.append("Key Length is equal to plain text. So the Key remains same \n");

           String o = "<b>"+vigenereCalculator.key+"</b>";
           vigenereCalculateStep.keyTextStep.append("\n\t\t\t\t\t\t");

           vigenereCalculateStep.keyTextStep.append(Html.fromHtml(o));
           vigenereCalculateStep.keyTextStep.append("\n\n\n");
       }
       else{
           String step1 = "<b> Step 1 : </b>";
           vigenereCalculateStep.keyTextStep.append(Html.fromHtml(step1));
           vigenereCalculateStep.keyTextStep.append("  :-  Recalculating the Key \n\n");
           vigenereCalculateStep.keyTextStep.append("New key becomes \n\n");

           vigenereCalculateStep.keyTextStep.append(vigenereCalculator.key);
           vigenereCalculateStep.keyTextStep.append("\n\n\n");
       }


       // Cipher text code
        String step2 = "<b> Step 2 : </b>";
        vigenereCalculateStep.keyTextStep.append(Html.fromHtml(step2));
        vigenereCalculateStep.keyTextStep.append("  :-  Calculation of Cipher Text \n\n");
        int i=0;
        for(String a : ctStep){
            vigenereCalculateStep.keyTextStep.append("      for i = "+ i + ", " +a+"\n");
            i++;
        }

        String ctS = "<b>"+ctStep.get(ctStep.size()-1)+"</b>";
        vigenereCalculateStep.keyTextStep.append("\n\t\t\tCipher Text is ");
        vigenereCalculateStep.keyTextStep.append(Html.fromHtml(ctS));
        vigenereCalculateStep.keyTextStep.append("\n\n\n");


        // Original text code
        String step3 = "<b> Step 3 : </b>";
        vigenereCalculateStep.keyTextStep.append(Html.fromHtml(step3));
        vigenereCalculateStep.keyTextStep.append("  :-  Calculation of Original Text \n\n");
        int j=0;
        for(String a : otStep){
            vigenereCalculateStep.keyTextStep.append("      for i = "+ j + ", " +a+"\n");
            j++;
        }

        String otS = "<b>"+otStep.get(otStep.size()-1)+"</b>";
        vigenereCalculateStep.keyTextStep.append("\n\t\t\tOriginal Text is ");
        vigenereCalculateStep.keyTextStep.append(Html.fromHtml(otS));

    }
}