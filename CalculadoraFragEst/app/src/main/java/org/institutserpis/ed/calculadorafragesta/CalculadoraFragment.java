package org.institutserpis.ed.calculadorafragesta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CalculadoraFragment extends Fragment {

    private TextView texto_numeros;
    private Button btn_c, btn_sum,btn_div,botn_mult,btn_res,btn_igual,btn_punto,btn_delete,btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    private double numero;
    private String operador;
    private double resul;

    public CalculadoraFragment() {
    }

    public static CalculadoraFragment newInstance(String param1, String param2) {
        CalculadoraFragment fragment = new CalculadoraFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    //Aqui cargarmos el codigo del main de la calculdora
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_calculadora, container, false);
        super.onCreate(savedInstanceState);

        texto_numeros = (TextView) view.findViewById(R.id.texto_numeros);

        btn0 = (Button) view.findViewById(R.id.numero_0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                texto_numeros.setText(operacion + "0");
            }
        });
        btn1 = (Button) view.findViewById(R.id.numero_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                texto_numeros.setText(operacion + "1");
            }
        });
        btn2 = (Button) view.findViewById(R.id.numero_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                texto_numeros.setText(operacion + "2");
            }
        });
        btn3 = (Button) view.findViewById(R.id.numero_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                texto_numeros.setText(operacion + "3");
            }
        });
        btn4 = (Button) view.findViewById(R.id.numero_4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                texto_numeros.setText(operacion + "4");
            }
        });
        btn5 = (Button) view.findViewById(R.id.numero_5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                texto_numeros.setText(operacion + "5");
            }
        });
        btn6 = (Button) view.findViewById(R.id.numero_6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                texto_numeros.setText(operacion + "6");
            }
        });
        btn7 = (Button) view.findViewById(R.id.numero_7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                texto_numeros.setText(operacion + "7");
            }
        });
        btn8 = (Button) view.findViewById(R.id.numero_8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                texto_numeros.setText(operacion + "8");
            }
        });
        btn9 = (Button) view.findViewById(R.id.numero_9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                texto_numeros.setText(operacion + "9");
            }
        });
        btn_c = (Button) view.findViewById(R.id.tecla_c);
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                if(operacion.length()>0){
                    texto_numeros.setText(operacion.substring(0, operacion.length()-1));
                }

            }
        });
        btn_delete = (Button) view.findViewById(R.id.tecla_borrar);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = "";
                texto_numeros.setText(operacion);
            }
        });
        btn_punto = (Button) view.findViewById(R.id.signo_punto);
        btn_punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                int cont=0;
                //Comprobamos si hay ya o no un punto para evitar poner mas de uno
                while(operacion.indexOf(".")> -1){
                    operacion = operacion.substring(operacion.indexOf(
                            ".")+".".length(),operacion.length());
                    cont++;
                }
                if (cont == 0){
                    texto_numeros.setText(operacion+".");
                }
            }
        });
        btn_sum = (Button) view.findViewById(R.id.tecla_mas);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                numero= Double.parseDouble(operacion);
                operador= "+";
                texto_numeros.setText("");
            }
        });
        btn_res = (Button) view.findViewById(R.id.tecla_menos);
        btn_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                numero = Double.parseDouble(operacion);
                operador = "-";
                texto_numeros.setText("");
            }
        });
        botn_mult = (Button) view.findViewById(R.id.tecla_multi);
        botn_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                numero = Double.parseDouble(operacion);
                operador = "*";
                texto_numeros.setText("");
            }
        });
        btn_div = (Button) view.findViewById(R.id.tecla_dividir);
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                numero = Double.parseDouble(operacion);
                operador = "/";
                texto_numeros.setText("");
            }
        });
        btn_igual = (Button) view.findViewById(R.id.signo_igual);
        btn_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operacion = texto_numeros.getText().toString();
                if(operador.equals("-")){
                    resul = numero - Double.parseDouble(operacion);
                    texto_numeros.setText(String.valueOf(resul));
                }
                else if(operador.equals("+")){
                    resul = numero + Double.parseDouble(operacion);
                    texto_numeros.setText(String.valueOf(resul));
                }
                else if(operador.equals("/")){
                    resul = numero / Double.parseDouble(operacion);
                    texto_numeros.setText(String.valueOf(resul));
                }
                else if(operador.equals("*")){
                    resul = numero * Double.parseDouble(operacion);
                    texto_numeros.setText(String.valueOf(resul));
                }
            }
        });
        return view;
    }
}