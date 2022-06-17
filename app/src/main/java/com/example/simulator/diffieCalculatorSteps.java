package com.example.simulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import simulator.R;

public class diffieCalculatorSteps extends AppCompatActivity {

     static TextView diffieStepTextClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diffie_calculator_steps);

        diffieStepTextClass = findViewById(R.id.diffieStepText);

        DiffieHellamStep.diffieStep();

    }

}

class DiffieHellamStep extends diffieCalculator{
    public static void diffieStep(){

//        Given
        String G = "<b> Given :- </b>";

        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml(G));
        diffieCalculatorSteps.diffieStepTextClass.append("\t\t\t\t\n");
        diffieCalculatorSteps.diffieStepTextClass.append("\t\t\t\t\t\t\t\t\t\t\t\tG = " + g.getText().toString()+"\n");
        diffieCalculatorSteps.diffieStepTextClass.append("\t\t\t\t\t\t\t\t\t\t\t\tN = " + n.getText().toString()+"\n");
        diffieCalculatorSteps.diffieStepTextClass.append("\t\t\t\t\t\t\t\t\t\t\t\tX = " + x.getText().toString()+"\n");
        diffieCalculatorSteps.diffieStepTextClass.append("\t\t\t\t\t\t\t\t\t\t\t\tY = " + y.getText().toString()+"\n\n");

        String dSol = "<b> Solution :- </b>";
        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml(dSol));
        diffieCalculatorSteps.diffieStepTextClass.append("\t\t\t\t\n\n");
        diffieCalculatorSteps.diffieStepTextClass.append("\t\t\t\t\t\t\t\t\t\t");
        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml("<b>A = g<sup>x</sup> mod n</b>"));
        diffieCalculatorSteps.diffieStepTextClass.append("\n\n\t\t\t\t\t\t\t\t\t\tA = ");
        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml(diffieCalculator.at1+"<sup>"+diffieCalculator.at2+"</sup>"+" mod "+n.getText().toString()));
        diffieCalculatorSteps.diffieStepTextClass.append("\n\t\t\t\t\t\t\t\t\t\t\t\t= ");
        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml(" "+diffieCalculator.at3+" mod "+n.getText().toString()));
        diffieCalculatorSteps.diffieStepTextClass.append("\n\t\t\t\t\t\t\t\t\t\t\t\t=");
        diffieCalculatorSteps.diffieStepTextClass.append(" "+diffieCalculator.at4+"\n\n");


        diffieCalculatorSteps.diffieStepTextClass.append("\t\t\t\t\t\t\t\t\t\t");
        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml("<b>B = g<sup>y</sup> mod n</b>"));
        diffieCalculatorSteps.diffieStepTextClass.append("\n\n\t\t\t\t\t\t\t\t\t\tB = ");
        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml(diffieCalculator.bt1+"<sup>"+diffieCalculator.bt2+"</sup>"+" mod "+n.getText().toString()));
        diffieCalculatorSteps.diffieStepTextClass.append("\n\t\t\t\t\t\t\t\t\t\t\t\t= ");
        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml(" "+diffieCalculator.bt3+" mod "+n.getText().toString()));
        diffieCalculatorSteps.diffieStepTextClass.append("\n\t\t\t\t\t\t\t\t\t\t\t\t=");
        diffieCalculatorSteps.diffieStepTextClass.append(" "+diffieCalculator.bt4+"\n\n");

        diffieCalculatorSteps.diffieStepTextClass.append("\t\t\t\t\t\t\t\t\t\t");
        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml("<b>K1 = B<sup>x</sup> mod n</b>"));
        diffieCalculatorSteps.diffieStepTextClass.append("\n\n\t\t\t\t\t\t\t\t\t\tK1 = ");
        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml(diffieCalculator.k1t1+"<sup>"+diffieCalculator.k1t2+"</sup>"+" mod "+n.getText().toString()));
        diffieCalculatorSteps.diffieStepTextClass.append("\n\t\t\t\t\t\t\t\t\t\t\t\t= ");
        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml(" "+diffieCalculator.k1t3+" mod "+n.getText().toString()));
        diffieCalculatorSteps.diffieStepTextClass.append("\n\t\t\t\t\t\t\t\t\t\t\t\t=");
        diffieCalculatorSteps.diffieStepTextClass.append(" "+diffieCalculator.k1t4+"\n\n");

        diffieCalculatorSteps.diffieStepTextClass.append("\t\t\t\t\t\t\t\t\t\t");
        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml("<b>K2 = A<sup>y</sup> mod n</b>"));
        diffieCalculatorSteps.diffieStepTextClass.append("\n\n\t\t\t\t\t\t\t\t\t\tK2 = ");
        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml(diffieCalculator.k2t1+"<sup>"+diffieCalculator.k2t2+"</sup>"+" mod "+n.getText().toString()));
        diffieCalculatorSteps.diffieStepTextClass.append("\n\t\t\t\t\t\t\t\t\t\t\t\t= ");
        diffieCalculatorSteps.diffieStepTextClass.append(Html.fromHtml(" "+diffieCalculator.k2t3+" mod "+n.getText().toString()));
        diffieCalculatorSteps.diffieStepTextClass.append("\n\t\t\t\t\t\t\t\t\t\t\t\t=");
        diffieCalculatorSteps.diffieStepTextClass.append(" "+diffieCalculator.k2t4+"\n\n");
    }
}