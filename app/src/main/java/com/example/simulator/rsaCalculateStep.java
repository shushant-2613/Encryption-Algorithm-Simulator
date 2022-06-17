package com.example.simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import simulator.R;

public class rsaCalculateStep extends AppCompatActivity {

     static TextView pTextStep;
     static TextView dTextStep;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsa_calculate_step);

        pTextStep = findViewById(R.id.pTextVigenere);
        dTextStep = findViewById(R.id.keyTextVigenere);

        Abc.dispalyRsaStep();
    }
}

class Abc extends rsaCalculator{

    @SuppressLint("SetTextI18n")
    public static void dispalyRsaStep() {

//        Given
        String g = "<b> Given </b>";
        rsaCalculateStep.pTextStep.append(Html.fromHtml(g));
        rsaCalculateStep.pTextStep.append("\t\t:-\t\t");
        rsaCalculateStep.pTextStep.append("p = " + p.getText().toString()+"\n");
        rsaCalculateStep.pTextStep.append("                    q = " + q.getText().toString()+"\n");
        rsaCalculateStep.pTextStep.append("                    e = " + e.getText().toString()+"\n");
        rsaCalculateStep.pTextStep.append("                    pt = " + pt.getText().toString()+"\n");



//        Output
        int k=1;

            rsaCalculateStep.dTextStep.append("Step 1 : Calculation of N \n\n\n");
            String N = "<b>\t\t\t\t\t\t\t\t\t\t ∅(N) = (p-1) * (q-1)</b>";
            rsaCalculateStep.dTextStep.append(Html.fromHtml(N));
            rsaCalculateStep.dTextStep.append("\n\n\n");
            rsaCalculateStep.dTextStep.append("         ∅(N) = "+ (Integer.parseInt((p.getText().toString())) - 1) +" * "+ (Integer.parseInt((q.getText().toString())) - 1) +" = "+phiN+"\n\n");

            rsaCalculateStep.dTextStep.append("\n\nStep 2 : Calculation of Decryption key (d) \n\n\n");
            String d = "<b> \t\t\t\t\t\t\t\t\t\t d = (K * ∅(N) + 1) / e </b>";
            rsaCalculateStep.dTextStep.append(Html.fromHtml(d));
            rsaCalculateStep.dTextStep.append("\n\n\n");

        for (int i=0; i<dStep.size(); i++){

            if(i == dStep.size()-1){
                rsaCalculateStep.dTextStep.append("         for K = "+k + ", " + dStep.get(i) + " is divisible by "+ e.getText().toString() +"\n\n");
            }
            else{
                rsaCalculateStep.dTextStep.append("         for K = "+k+ ", " + dStep.get(i) + " is not divisible by "+ e.getText().toString() +"\n\n");
            }


              k++;

        }

        String dFinalValue = "<b>"+rsaCalculator.d+"</b>";
        rsaCalculateStep.dTextStep.append("\t\t\tHence, the value of d is "+Html.fromHtml(dFinalValue)+"\n\n\n");

        String step3 = "<b> Step 3 </b>";
        rsaCalculateStep.dTextStep.append("\t\t");
        rsaCalculateStep.dTextStep.append(Html.fromHtml(step3));
        rsaCalculateStep.dTextStep.append("  :-  Calculation of Cipher Text (CT) \n\n");
        rsaCalculateStep.dTextStep.append(" \t\t\t\t\t\t\t\t\t\t");
        rsaCalculateStep.dTextStep.append(Html.fromHtml("<b>P<sup>e</sup> mod n</b>"));
        rsaCalculateStep.dTextStep.append("\n\n\t\t\t\t\t\t\t\t\t\tCipher Text = " );
        rsaCalculateStep.dTextStep.append(Html.fromHtml(rsaCalculator.pt.getText().toString() + "<sup>" + rsaCalculator.e.getText().toString() + "</sup>" + " mod " + rsaCalculator.N));
        String ctStep = "<b>"+rsaCalculator.finalCt+"</b>";
        rsaCalculateStep.dTextStep.append("\n\n\t\t\t\t\t\t\t\t\t" + " Cipher Text is ");
        rsaCalculateStep.dTextStep.append(Html.fromHtml(ctStep));



        String step4 = "<b> Step 4 </b>";
        rsaCalculateStep.dTextStep.append("\n\n\n\t\t");
        rsaCalculateStep.dTextStep.append(Html.fromHtml(step4));
        rsaCalculateStep.dTextStep.append("  :-  Calculation of Plain Text (CT) \n\n");
        rsaCalculateStep.dTextStep.append("\t\t\t\t\t\t\t\t\t\t");
        rsaCalculateStep.dTextStep.append(Html.fromHtml("<b>C<sup>d</sup> mod n</b>"));

        rsaCalculateStep.dTextStep.append("\n\n\t\t\t\t\t\t\t\t\t\tCipher Text = " );
        rsaCalculateStep.dTextStep.append(Html.fromHtml(rsaCalculator.finalCt + "<sup>" + rsaCalculator.d + "</sup>" + " mod " + rsaCalculator.N));
        String ptStep = "<b>"+rsaCalculator.finalPt+"</b>";
        rsaCalculateStep.dTextStep.append("\n\n\t\t\t\t\t\t\t\t\t" + " Plain Text is ");
        rsaCalculateStep.dTextStep.append(Html.fromHtml(ptStep));

    }
}