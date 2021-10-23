package com.nb.testnoabarmatz;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView result;
    TextView calc;

    private char opr = ' ';
    private double holdNumber = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPointer();
    }

    private void setPointer() {
        //we connecting between our layout (view) to our intent(code)
        result = findViewById(R.id.resultView);
        calc = findViewById(R.id.calcView);
    }

    @Override
    public void onClick(View view) {
        StringBuilder sbCalc = new StringBuilder();
        sbCalc.append(calc.getText().toString());

        StringBuilder sbResult = new StringBuilder();
        sbResult.append(result.getText().toString());


        switch (view.getId()) {

            case R.id.num1:
                sbCalc.append("1");
                calc.setText(sbCalc.toString());
                sbResult.append("1");
                result.setText(sbResult.toString());
                break;
            case R.id.num2:
                sbCalc.append("2");
                calc.setText(sbCalc.toString());
                sbResult.append("2");
                result.setText(sbResult.toString());
                break;
            case R.id.num3:
                sbCalc.append("3");
                calc.setText(sbCalc.toString());
                sbResult.append("3");
                result.setText(sbResult.toString());
                break;
            case R.id.num4:
                sbCalc.append("4");
                calc.setText(sbCalc.toString());
                sbResult.append("4");
                result.setText(sbResult.toString());
                break;
            case R.id.num5:
                sbCalc.append("5");
                calc.setText(sbCalc.toString());
                sbResult.append("5");
                result.setText(sbResult.toString());
                break;
            case R.id.num6:
                sbCalc.append("6");
                calc.setText(sbCalc.toString());
                sbResult.append("6");
                result.setText(sbResult.toString());
                break;
            case R.id.num7:
                sbCalc.append("7");
                calc.setText(sbCalc.toString());
                sbResult.append("7");
                result.setText(sbResult.toString());
                break;
            case R.id.num8:
                sbCalc.append("8");
                calc.setText(sbCalc.toString());
                sbResult.append("8");
                result.setText(sbResult.toString());
                break;
            case R.id.num9:
                sbCalc.append("9");
                calc.setText(sbCalc.toString());
                sbResult.append("9");
                result.setText(sbResult.toString());
                break;
            case R.id.num0:
                sbCalc.append("0");
                calc.setText(sbCalc.toString());
                sbResult.append("0");
                result.setText(sbResult.toString());
                break;
            case R.id.clear:
                result.setText("");
                calc.setText(" ");
                opr = ' ';
                holdNumber = 0;
                return;
            case R.id.point:
                if (result.getText().toString().contains(".")) {
                    return;
                }
                sbCalc.append(".");
                calc.setText(sbCalc.toString());
                sbResult.append(".");
                result.setText(sbResult.toString());
                break;
            case R.id.divide:
                if(opr != ' '){
                    calc();
                }
                opr = '/';
                result.setText(sbResult.toString());
                holdNumber = Double.parseDouble(result.getText().toString());
                sbCalc.append("/");
                calc.setText(sbCalc.toString());
                result.setText("");
                return;
            case R.id.multiply:
                if(opr != ' '){
                    calc();
                }
                opr = '*';
                holdNumber = Double.parseDouble(result.getText().toString());
                sbCalc.append("*");
                calc.setText(sbCalc.toString());
                result.setText("");
                return;
            case R.id.minus:
                if(opr != ' '){
                    calc();
                }
                opr = '-';
                holdNumber = Double.parseDouble(result.getText().toString());
                result.setText("");
                sbCalc.append("-");
                calc.setText(sbCalc.toString());
                return;
            case R.id.plus:
                if(opr != ' '){
                    calc();
                }
                opr = '+';
                holdNumber = Double.parseDouble(result.getText().toString());
                result.setText("");
                sbCalc.append("+");
                calc.setText(sbCalc.toString());
                return;
            case R.id.equal:
                calc();
                DecimalFormat df = new DecimalFormat("0.###");
                calc.setText(String.format(String.valueOf(df.format(holdNumber))));
                opr = ' ';
                return;
        }
        calc.setText(sbCalc.toString());
    }

    private void calc() {
        if (result.getText().toString().length() < 1) return;
        Double myNumber = Double.parseDouble(result.getText().toString());
        Double newResult = 0.0;
        switch (opr) {
            case '/':
                if (myNumber == 0) {
                    result.setText("can't divide by 0");
                    return;
                }
                newResult = holdNumber / myNumber;
                break;
            case '*':
                newResult = holdNumber * myNumber;
                break;
            case '-':
                newResult = holdNumber - myNumber;
                break;
            case '+':
                newResult = holdNumber + myNumber;
                break;
        }

        DecimalFormat df = new DecimalFormat("0.###");
        result.setText(df.format(newResult));
        holdNumber = newResult;

        //opr = ' ';
    }
}