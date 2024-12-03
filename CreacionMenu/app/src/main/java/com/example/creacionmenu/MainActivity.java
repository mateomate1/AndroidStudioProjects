package com.example.creacionmenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mimenu) {
        getMenuInflater().inflate(R.menu.menu_activity, mimenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu) {
        int id = opcion_menu.getItemId();

        // Gestionar las opciones del menú
        if (id == R.id.Opcion_menu_1) {
            Toast.makeText(this, "Madrid", Toast.LENGTH_LONG).show();
        } else if (id == R.id.Opcion_menu_2) {
            // Si seleccionan Cataluña, mostrar las provincias
        } else if (id == R.id.provincia_bcn) {
            // Mostrar tres poblaciones de Barcelona
            Toast.makeText(this, "Barcelona: Terrassa, Sabadell, Mataró", Toast.LENGTH_LONG).show();
        } else if (id == R.id.provincia_gir) {
            // Mostrar tres poblaciones de Girona
            Toast.makeText(this, "Girona: Figueres, Blanes, Palafrugell", Toast.LENGTH_LONG).show();
        } else if (id == R.id.provincia_tar) {
            // Mostrar tres poblaciones de Tarragona
            Toast.makeText(this, "Tarragona: Valls, Reus, Salou", Toast.LENGTH_LONG).show();
        } else if (id == R.id.provincia_lle) {
            // Mostrar tres poblaciones de Lleida
            Toast.makeText(this, "Lleida: Cervera, Balaguer, Agramunt", Toast.LENGTH_LONG).show();
        } else if (id == R.id.Opcion_menu_3) {
            // Si seleccionan Aragón, mostrar las provincias
        } else if (id == R.id.provincia_zar) {
            // Mostrar tres poblaciones de Zaragoza
            Toast.makeText(this, "Zaragoza: Ejea de los Caballeros, Utebo, La Almunia de Doña Godina", Toast.LENGTH_LONG).show();
        } else if (id == R.id.provincia_hue) {
            // Mostrar tres poblaciones de Huesca
            Toast.makeText(this, "Huesca: Monzón, Jaca, Sabiñánigo", Toast.LENGTH_LONG).show();
        } else if (id == R.id.provincia_ter) {
            // Mostrar tres poblaciones de Teruel
            Toast.makeText(this, "Teruel: Alcañiz, Calamocha, Orihuela del Tremedal", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(opcion_menu);
    }

}