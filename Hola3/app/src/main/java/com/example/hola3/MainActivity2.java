package com.example.hola3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView recibirTxt;
    Button botonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recibirTxt = (TextView) findViewById(R.id.texto2);
        botonVolver = (Button) findViewById(R.id.boton2);

        Bundle recibirBundle = getIntent().getExtras();
        final String saludo = (String) recibirBundle.getString("TEXTO");
        recibirTxt.setText(saludo);

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity2.this,MainActivity.class);
                Bundle miBundle = new Bundle();
                String mensajeDevuelto= "Devuelvo a Principal " + saludo;
                miBundle.putString("DEVUELTO", mensajeDevuelto);
                miIntent.putExtras(miBundle);
                setResult(RESULT_OK,miIntent);
                finish();


            }
        });
    }
}