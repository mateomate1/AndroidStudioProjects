package com.example.ejerciciofragmentdinamico;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaccion;
    Fragment fragment1, fragment2, fragment_manzanas, fragment_peras, fragment_platanos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment_manzanas = new Manzanas();
        fragment_peras = new Peras();
        fragment_platanos = new Platanos();

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentInferior, fragment2).commit();
    }

    public void changeFragment(int ID){
        transaccion = getSupportFragmentManager().beginTransaction();

        if(ID==R.id.buttonManzana){
            transaccion.replace(R.id.fragmentInferior, fragment_manzanas);
            transaccion.addToBackStack(null);
        } else if (ID==R.id.buttonPera) {
            transaccion.replace(R.id.fragmentInferior, fragment_peras);
            transaccion.addToBackStack(null);
        } else if (ID==R.id.buttonPlatano) {
            transaccion.replace(R.id.fragmentInferior, fragment_platanos);
            transaccion.addToBackStack(null);
        }
        transaccion.commit();
    }

}