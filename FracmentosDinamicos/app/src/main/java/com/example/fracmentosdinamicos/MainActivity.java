package com.example.fracmentosdinamicos;

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
    FragmentTransaction transaction;
    Fragment fragmentInicio, fragmentRojo, fragmentVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentInicio = new FragmentInicio();
        fragmentRojo = new FragmentRojo();
        fragmentVerde = new FragmentVerde();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragmentos,fragmentInicio).commit();
    }
    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        if (view.getId()==R.id.btnRojo){
            transaction.replace(R.id.contenedorFragmentos,fragmentRojo);
            transaction.addToBackStack(null);
        } else if (view.getId()==R.id.btnVerde){
            transaction.replace(R.id.contenedorFragmentos,fragmentVerde);
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}