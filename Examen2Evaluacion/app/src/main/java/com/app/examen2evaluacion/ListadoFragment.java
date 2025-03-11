package com.app.examen2evaluacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ListadoFragment extends Fragment {
    GridView gridView;
    List<Contacto> lista = new ArrayList<>();

    public ListadoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_listado, container, false);
        gridView = v.findViewById(R.id.lista);

        Contacto c1 = new Contacto("Mama", "689754321", "mama@gmail.com", R.drawable.ic_android_black_24dp);
        Contacto c2 = new Contacto("Papa", "654321987", "papa@gmail.com", R.drawable.ic_android_black_24dp);
        Contacto c3 = new Contacto("Hermano", "693852741", "mama@gmail.com", R.drawable.ic_android_black_24dp);
        Contacto c4 = new Contacto("Hermana", "612359847", "mama@gmail.com", R.drawable.ic_android_black_24dp);

        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.add(c4);

        if (lista != null && !lista.isEmpty()) {
            AdaptadorContacto adapter = new AdaptadorContacto(v.getContext(), R.layout.lista_item, lista);
            gridView.setAdapter(adapter);
        }
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contacto contactoSeleccionado = lista.get(i);
                Toast.makeText(v.getContext(), "Seleccionado: " + contactoSeleccionado.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}