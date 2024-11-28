package com.example.listviewpersonalizado;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listviewpersonalizado.Ejemplo;
import com.example.listviewpersonalizado.MiAdaptadorEjemplo;
import com.example.listviewpersonalizado.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lista;
    List<Ejemplo> ejemploList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.listViewEjemplo);
        ejemploList = new ArrayList<>();
        ejemploList.add(new Ejemplo("Título Ejemplo 1", "Subtitulo Ejemplo 1", "", 2));
        ejemploList.add(new Ejemplo("Título Ejemplo 2", "Subtitulo Ejemplo 2", "", 2));
        ejemploList.add(new Ejemplo("Título Ejemplo 3", "Subtitulo Ejemplo 3", "", 2));
        ejemploList.add(new Ejemplo("Título Ejemplo 4", "Subtitulo Ejemplo 4", "", 2));
        ejemploList.add(new Ejemplo("Título Ejemplo 5", "Subtitulo Ejemplo 5", "", 2));
        ejemploList.add(new Ejemplo("Título Ejemplo 6", "Subtitulo Ejemplo 6", "", 2));
        MiAdaptadorEjemplo adaptadorEjemplo = new MiAdaptadorEjemplo(
                this,
                R.layout.ejemplo_item,
                ejemploList
        );
        lista.setAdapter(adaptadorEjemplo);
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "El ejemplo seleccionado es "+ejemploList.get(i).getTitulo(), Toast.LENGTH_SHORT).show();
    }
}