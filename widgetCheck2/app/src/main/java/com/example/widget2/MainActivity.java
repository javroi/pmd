package com.example.widget2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    Button btnHoby;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialUISetup();
    }

    private void initialUISetup() {
        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCycling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);
        txtHobby = (TextView)findViewById(R.id.txtHobby);
        chkBoxCycling.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxTeaching.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxBlogging.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
    }
    class myCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            String[]mensaje = new String[3];

            if(isChecked){
                if (buttonView == chkBoxCycling){
                    mensaje[0]="Cycling";
                }

                if (buttonView == chkBoxTeaching){
                    mensaje[1]="Teaching";
                }

                if (buttonView == chkBoxBlogging){
                    mensaje[2]="Blogging";
                }

            }
            showTextNotification(mensaje);
        }
    }
    public void showTextNotification(String[]mensaje) {
        String strMensaje="";
        for (int i = 0; i<3; i++){
            strMensaje += mensaje[i];
        }
        txtHobby.setText(strMensaje);
    }
}