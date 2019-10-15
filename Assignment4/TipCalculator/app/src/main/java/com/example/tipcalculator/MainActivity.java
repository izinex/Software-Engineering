package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText getCheckAmount, getPartySize, tip15value, tip20value, tip25value, total15value, total20value, total25value;
    private Button ComputerTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCheckAmount = findViewById(R.id.checkAmountValue);
        getPartySize = findViewById(R.id.partySizeValue);
        tip15value = findViewById(R.id.tip15val);
        tip20value = findViewById(R.id.tip20val);
        tip25value = findViewById(R.id.tip25val);
        total15value = findViewById(R.id.total15val);
        total20value = findViewById(R.id.total20val);
        total25value = findViewById(R.id.total25val);

        ComputerTip = findViewById(R.id.button);
        ComputerTip.setOnClickListener(this);



    }

    public void onClick(View view) {

        String checkAmount = getCheckAmount.getText().toString();
        String partySize = getPartySize.getText().toString();






        if(checkAmount.length() > 0 && partySize.length() > 0){
            try {
                double checkAmount1 = Double.parseDouble(checkAmount);
                int partySizeint = Integer.parseInt(partySize);

                if (checkAmount.isEmpty() || checkAmount1 < 0 || partySizeint < 1 || partySize.isEmpty()) {
                    Toast.makeText(this, "Empty or Incorrect Amount", Toast.LENGTH_SHORT).show();
                } else {
                    double tip15 = (checkAmount1 / partySizeint) * .15;
                    double tip20 = (checkAmount1 / partySizeint) * .20;
                    double tip25 = (checkAmount1 / partySizeint) * .25;

                    double total15 = (checkAmount1 / partySizeint) + tip15;
                    double total20 = (checkAmount1 / partySizeint) + tip20;
                    double total25 = (checkAmount1 / partySizeint) + tip25;


                    tip15value.setText("" + tip15);
                    tip20value.setText("" + tip20);
                    tip25value.setText("" + tip25);
                    total15value.setText("" + total15);
                    total20value.setText("" + total20);
                    total25value.setText("" + total25);


                } // Write your code here

            } catch (Exception e) {
                Toast.makeText(this, "Enter only a number!", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        } else{
            Toast.makeText(this, "Enter a number!", Toast.LENGTH_SHORT).show();
        }
        }


    }
