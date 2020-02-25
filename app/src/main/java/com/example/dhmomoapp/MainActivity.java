package com.example.dhmomoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView balance;
    private TextView curr_balance;
    private EditText deposit;
    private EditText withdraw;
    private TextView charge;
    private EditText tax;
    private Button btn;
    int bank_charge;
    int tax_charged;
    int current_balance=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Dh Mobile Money App");
        charge=(TextView)findViewById(R.id.charge);
        balance= (TextView) findViewById(R.id.initial_balance);
        curr_balance=(TextView) findViewById(R.id.current_balance);
        deposit=(EditText) findViewById(R.id.deposit);
        withdraw=(EditText) findViewById(R.id.withdraw);
        btn=(Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int d=Integer.parseInt(deposit.getText().toString());
                int w=Integer.parseInt(withdraw.getText().toString());
                current_balance= current_balance + d;
                if (w < 500 && w <= 2500){
                    bank_charge =200;
                }
                else if(w >2500 && w<=5000){
                    bank_charge =450;
                }
                else if(w >5000 && w<=30000){
                    bank_charge =1000;
                }
                else if(w >30000 && w<=60000){
                    bank_charge =1550;
                }
                else if(w >60000 && w<=500000){
                    bank_charge =2050;
                }
                else if(w >500000 && w<=2000000){
                    bank_charge =2500;
                }
                else if(w >2000000 && w<=4000000){
                    bank_charge =2550;
                }
                else{
                    bank_charge=3000;
                }

                curr_balance.setText(String.valueOf("Current Balance: " +(current_balance -(w+bank_charge))));

                balance.setText(String.valueOf("Initial Balance: "+ current_balance));

                charge.setText(String.valueOf("Bank Charges: " + bank_charge));


            }
        });


    }
}
