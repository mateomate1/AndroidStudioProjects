package com.app.routetogether;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    List<Ruta> rutaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lista = (ListView) findViewById(R.id.lista);
        rutaList = new ArrayList<>();
        boolean[] dias = {true,true,true,true,true,false,false};
        boolean[] dias1 = {true, false, false, false, true, true, false};
        boolean[] dias2 = {true, true, true, true, true, true, false};
        boolean[] dias3 = {false, false, false, false, false, true, true};
        boolean[] dias4 = {false, false, false, false, false, false, true};

        rutaList.add(new Ruta("coche", "Casa a Uni", "C/ Imaginacion 123", "C/ Universidad X", dias, "08:30"));
        rutaList.add(new Ruta("bici", "Vuelta ciclista", "C/ Ejemplo 456", "Parque Central", dias3, "09:00"));
        rutaList.add(new Ruta("bus", "Centro Comercial", "Calle Luna 100", "Centro Comercial Mall", dias1, "16:00"));
        rutaList.add(new Ruta("tren", "Estación a Montaña", "Estación Central", "Estación Montaña", dias2, "08:00"));
        rutaList.add(new Ruta("viaandante", "Caminata Sendero", "Inicio Sendero", "Final Sendero", dias4, "15:30"));
        AdaptadorRuta adaptador = new AdaptadorRuta(
                this,
                R.layout.layout_rutas,
                rutaList
        );
        lista.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem opcion_menu){
        int id = opcion_menu.getItemId();
        if (id==R.id.opcNuevaRuta){
            Intent intent = new Intent(MainActivity.this, NuevaRuta.class);
            startActivity(intent);
        } if (id==R.id.opcBuscar){
            Intent intent = new Intent(MainActivity.this, buscador.class);
            startActivity(intent);
        } if (id==R.id.opcAjustes){

        }
        return true;
    }
}