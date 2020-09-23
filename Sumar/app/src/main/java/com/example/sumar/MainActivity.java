package com.example.sumar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txt_num1c = (EditText) findViewById(R.id.txt_num1);
        final EditText txt_num2c = (EditText) findViewById(R.id.txt_num2);
        final Button btn_sumc = (Button) findViewById(R.id.btn_sum);
        final TextView lbl_sumc = (TextView) findViewById(R.id.lbl_sum);

        btn_sumc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1_s, num2_s, sum_s;
                int num1, num2, sum;
                num1_s = txt_num1c.getText().toString();
                num2_s = txt_num2c.getText().toString();
                num1 = Integer.parseInt(num1_s);
                num2 = Integer.parseInt(num2_s);
                sum = num1 + num2;
                sum_s = String.valueOf(sum);
                lbl_sumc.setText(sum_s);

            }
        });
    }
}