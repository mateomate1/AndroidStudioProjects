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
    public boolean onCreateOptionsMenu(Menu mimenu) {
        getMenuInflater().inflate(R.menu.menu_activity, mimenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem opcion_menu) {
        int id = opcion_menu.getItemId();
        if (id==R.id.Opcion_menu_1){
            Toast.makeText(this, "Opcion menu 1", Toast.LENGTH_LONG).show();
        }
        if (id==R.id.Opcion_menu_2){
            Toast.makeText(this, "Opcion menu 2", Toast.LENGTH_LONG).show();
        }
        if (id==R.id.Opcion_menu_3){
            Toast.makeText(this, "Opcion menu 3", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}