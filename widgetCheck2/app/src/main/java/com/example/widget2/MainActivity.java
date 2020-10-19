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
            Boolean cycling = false, teaching = false, blogging = false;

            if(isChecked){
                if (buttonView == chkBoxCycling){
                    cycling = true;
                }
                else{
                    cycling = false;
                }
                if (buttonView == chkBoxTeaching){
                    teaching = true;
                }
                else{
                    teaching = false;
                }
                if (buttonView == chkBoxBlogging){
                    blogging = true;
                }
                else{
                    blogging = false;
                }
            }
            showTextNotification(cycling,teaching,blogging);
        }
    }
    public void showTextNotification(Boolean cycling, Boolean teaching,Boolean blogging) {
        String strMensaje = "";
        if (cycling){
            strMensaje+= "cycling";
        }
        if (teaching) {
            strMensaje+= "teaching";
        }
        if (blogging){
            strMensaje+="blogging";
        }
        txtHobby.setText(strMensaje);
    }
}