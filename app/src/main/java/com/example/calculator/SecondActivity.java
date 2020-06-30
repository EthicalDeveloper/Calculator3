package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnDivide;
    private Button btnMultiply;
    private Button btnPercentage;
    private Button btnDot;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnEqual;
    private Button btnNegPos;
    private Button btnAC;
    private TextView resultTxt;
    private TextView finalTxt;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = 'x';
    private final char DIVISION = '/';
    private final char PERCENT = '%';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setButtonsById();



        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxt.setText(resultTxt.getText().toString() + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxt.setText(resultTxt.getText().toString() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxt.setText(resultTxt.getText().toString() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxt.setText(resultTxt.getText().toString() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxt.setText(resultTxt.getText().toString() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxt.setText(resultTxt.getText().toString() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxt.setText(resultTxt.getText().toString() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxt.setText(resultTxt.getText().toString() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxt.setText(resultTxt.getText().toString() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTxt.setText(resultTxt.getText().toString() + "9");
            }
        });


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                finalTxt.setText(String.valueOf(val1) + " + ");
                resultTxt.setText(null);
            }
        });


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                finalTxt.setText(String.valueOf(val1) + " - ");
                resultTxt.setText(null);
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                finalTxt.setText(String.valueOf(val1) + " / ");
                resultTxt.setText(null);
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                finalTxt.setText(String.valueOf(val1) + " x ");
                resultTxt.setText(null);
            }
        });

        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = PERCENT;
                finalTxt.setText(String.valueOf(val1) + " % ");
                resultTxt.setText(null);
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQU;
                finalTxt.setText(finalTxt.getText().toString() + String.valueOf(val2) + " = " + String.valueOf(val1));
                resultTxt.setText(null);
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(resultTxt.getText().length() > 0){
                    CharSequence name = resultTxt.getText().toString();
                    resultTxt.setText(name.subSequence(0,name.length() - 1));
                }else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    resultTxt.setText(null);
                    finalTxt.setText(null);
                }
            }
        });














    }

    private void setButtonsById(){
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnDivide = (Button)findViewById(R.id.btnDivide);
        btnMultiply = (Button)findViewById(R.id.btnMultiply);
        btnPercentage = (Button)findViewById(R.id.btnPercent);
        btnDot = (Button)findViewById(R.id.btnDot);
        btnPlus = (Button)findViewById(R.id.btnPlus);
        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnEqual = (Button)findViewById(R.id.btnEqual);
        btnNegPos = (Button)findViewById(R.id.btnNegPos);
        btnAC = (Button)findViewById(R.id.btnAC);
        resultTxt = (TextView)findViewById(R.id.resultTxt);
        finalTxt = (TextView)findViewById(R.id.finalTxt);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(resultTxt.getText().toString());

            switch (ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;

                case PERCENT:
                    val1 = val1 / 100;
                    break;

                case EQU:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(resultTxt.getText().toString());
        }
    }
}
