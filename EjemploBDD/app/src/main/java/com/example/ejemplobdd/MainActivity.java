package com.example.ejemplobdd;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ejemplobdd.db.DBAyudante;

public class MainActivity extends AppCompatActivity {
    Button btnBDD;
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

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnBDD = findViewById(R.id.btnBDD);
        btnBDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBAyudante dbAyudante = new DBAyudante(MainActivity.this);
                SQLiteDatabase db = dbAyudante.getWritableDatabase();
                if(db != null){
                    Toast.makeText(MainActivity.this, "Base de datos creada", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Error al crear la base de datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuNuevo) {
            nuevoRegistro();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this, FormularioActivity.class);
        startActivity(intent);
    }
}