package org.institutserpis.ed.calculadorafragdin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        WindowManager wm = getWindowManager();
        Display d = wm.getDefaultDisplay();

        CalculadoraFragment fragment = new CalculadoraFragment();
        fragmentTransaction.replace(android.R.id.content, fragment)
                .commit();
    }
}