package com.example.suma2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText dig1;
    private EditText dig2;
    private TextView resultado;
    private Button sumar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dig1 = findViewById(R.id.dig1);
        dig2 = findViewById(R.id.dig2);
        resultado = findViewById(R.id.resul);
        sumar = findViewById(R.id.btn_suma);

        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1,num2;
                int resul_int;
                num1 = dig1.getText().toString();
                num2 = dig2.getText().toString();
                resul_int = (Integer.parseInt(num1)+Integer.parseInt(num2));
                resultado.setText(Integer.toString(resul_int));

            }
        });
    }
}