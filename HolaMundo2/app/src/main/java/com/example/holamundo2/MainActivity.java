package com.example.holamundo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txt1_c = (EditText) findViewById(R.id.txt1);
        final Button btn1_c = (Button) findViewById(R.id.btn1);
        final TextView lbl1_c = (TextView) findViewById(R.id.lbl1);

        txt1_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1_c.setText("");
            }
        });

        btn1_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = "Te saludo "+ txt1_c.getText();
                lbl1_c.setText(mensaje);
            }
        });

    }
}