package com.example.sumar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        resultado = (TextView) findViewById(R.id.resultado);

        Bundle recibirBundle = getIntent().getExtras();
        String textoBundle =(String) recibirBundle.getString("RESULTADO");
        resultado.setText(textoBundle);
    }
}