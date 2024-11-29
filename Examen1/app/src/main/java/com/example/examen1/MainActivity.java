package com.example.examen1;

import android.content.Intent;
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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem opcion_menu) {
        int id = opcion_menu.getItemId();
        if (id==R.id.opcCalculo){
            Intent intent = new Intent(MainActivity.this, ActivityCalculo.class);
            startActivity(intent);
        }
        if (id==R.id.opcAlarma){
            Intent intent = new Intent(Intent.EXTRA_ALARM_COUNT);
            startActivity(intent);
        }
        if (id==R.id.opcMenu){

        }
        if (id==R.id.opcAcercaDe){
            Toast.makeText(this, "Esta es la APP de Mateo Ayarra Barbero", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}