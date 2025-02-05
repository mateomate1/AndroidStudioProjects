package com.example.listviewpersonalizado;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView lista;
    List<Ejemplo> ejemploList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (GridView) findViewById(R.id.listViewEjemplo);
        ejemploList = new ArrayList<>();
        ejemploList.add(new Ejemplo("MA1", "Subtitulo Ejemplo 1", "", 2));
        ejemploList.add(new Ejemplo("MA2", "Subtitulo Ejemplo 2", "", 2));
        ejemploList.add(new Ejemplo("MA3", "Subtitulo Ejemplo 3", "", 2));
        ejemploList.add(new Ejemplo("MA4", "Subtitulo Ejemplo 4", "", 2));
        ejemploList.add(new Ejemplo("MA5", "Subtitulo Ejemplo 5", "", 2));
        ejemploList.add(new Ejemplo("MA6", "Subtitulo Ejemplo 6", "", 2));

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