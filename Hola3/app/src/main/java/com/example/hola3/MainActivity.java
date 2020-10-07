package com.example.hola3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int COD_RESPUESTA=0;
    EditText texto;
    Button boton;
    TextView saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (EditText) findViewById(R.id.cuadroTexto);
        boton = (Button) findViewById(R.id.boton1);
        saludo = (TextView) findViewById(R.id.texto1);

        texto.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean b){
                if (b) texto.setText("");
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this,MainActivity2.class);
                Bundle miBundle = new Bundle();
                String cajaTexto =texto.getText().toString();
                String mensaje = "Te saludo "+ cajaTexto;
                miBundle.putString("TEXTO", mensaje);
                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent,COD_RESPUESTA);

            }
        });

    }

    @Override
    protected void onActivityResult(int cod_resp, int cod_result,Intent intent) {
        if (cod_result == RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            saludo.setText(otroBundle.getString("DEVUELTO"));
        }
    }
}