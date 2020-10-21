package com.example.controldeseleccion3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Titular[] datos = new Titular[]{
            new Titular("Manolo","Garcia",R.drawable.foto_perfil),
            new Titular("Consuelo","Martin",R.drawable.foto_perfil),
            new Titular("Luis","Poveda",R.drawable.foto_perfil),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView lstOpciones = (ListView)findViewById(R.id.lstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "Nombre: "+datos[position].getTitulo1()+"Apellidos: "+datos[position].getTitulo2();
            }
        });
    }
    class AdaptadorTitulares extends ArrayAdapter{
        Activity context;

        AdaptadorTitulares(Activity context){
            super(context, R.layout.listitem_titular,datos);
            this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getView(int i, View convertView, ViewGroup paret){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_titular, null);

            TextView itTitulo1 = (TextView)item.findViewById(R.id.itTitulo1);
            itTitulo1.setText(datos[i].getTitulo1());

            TextView itTitulo2 = (TextView)item.findViewById(R.id.itTitulo2);
            itTitulo2.setText(datos[i].getTitulo2());

            ImageView imagen = (ImageView)item.findViewById(R.id.itImagen);
            imagen.setBackground(getDrawable(datos[i].getImg()));

            return (item);
        }
    }
}

