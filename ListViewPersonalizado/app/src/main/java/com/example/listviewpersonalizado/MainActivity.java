package com.example.gridview;

import android.os.Bundle;
import android.widget.ListView;

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

public class MainActivity extends AppCompatActivity {

    ListView lista;
    List<Ejemplo> ejemploList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        MiAdaptadorEjemplo adaptadorEjemplo = new MiAdaptadorEjemplo(
                this
        );
        lista = (ListView) findViewById(R.id.listViewEjemplo);
        ejemploList = new ArrayList<>();
        ejemploList.add(new Ejemplo("Título Ejemplo 1", "Subtitulo Ejemplo 1", "", 2));
        ejemploList.add(new Ejemplo("Título Ejemplo 2", "Subtitulo Ejemplo 2", "", 2));
        ejemploList.add(new Ejemplo("Título Ejemplo 3", "Subtitulo Ejemplo 3", "", 2));
        ejemploList.add(new Ejemplo("Título Ejemplo 4", "Subtitulo Ejemplo 4", "", 2));
        ejemploList.add(new Ejemplo("Título Ejemplo 5", "Subtitulo Ejemplo 5", "", 2));
        ejemploList.add(new Ejemplo("Título Ejemplo 6", "Subtitulo Ejemplo 6", "", 2));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}