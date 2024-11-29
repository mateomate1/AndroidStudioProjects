package com.example.examen1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView lista;
    List<Ejemplo> ejemploList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lista = (ListView) findViewById(R.id.listViewEjemplo);
        ejemploList = new ArrayList<>();
        ejemploList.add(new Ejemplo("MA1","",""));
        ejemploList.add(new Ejemplo("MA2","",""));
        ejemploList.add(new Ejemplo("MA3","",""));
        ejemploList.add(new Ejemplo("MA4","",""));

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