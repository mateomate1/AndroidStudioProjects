package com.app.examen;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction transaction;
    Fragment fragmentoSaludo, fragmentoLista, fragmentoAzul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fragmentoSaludo = new SaludoFragment();
        fragmentoLista = new ListadoFragment();
        fragmentoAzul = new AzulFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, fragmentoSaludo).commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu) {
        getMenuInflater().inflate(R.menu.activity_menu, mimenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        transaction = getSupportFragmentManager().beginTransaction();
        if(id == R.id.opcnListado){
            transaction.replace(R.id.contenedor, fragmentoLista);
            transaction.addToBackStack(null);
        } else if (id == R.id.opcNotificacion){
            transaction.replace(R.id.contenedor, fragmentoAzul);
            transaction.addToBackStack(null);
        } else if (id == R.id.opcAlarma){
            //Codigo
        } else if (id == R.id.opcCalculo){
            //Codigo
        }
        transaction.commit();
        return super.onOptionsItemSelected(item);
    }
}