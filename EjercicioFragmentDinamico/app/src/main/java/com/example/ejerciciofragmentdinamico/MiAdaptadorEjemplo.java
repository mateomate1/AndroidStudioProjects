package com.example.ejerciciofragmentdinamico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MiAdaptadorEjemplo extends ArrayAdapter<Ejemplo> {
    Context ctx;
    int layoutTemplate;
    List<Ejemplo> ejemploList;

    public MiAdaptadorEjemplo(@NonNull Context context, int resource, @NonNull List<Ejemplo> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.ejemploList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent,false);
        //Obtener la informacion del elemento de la lista
        Ejemplo elementoActual = ejemploList.get(position);
        //Rescatar los elementos  de la interfaz de usuario de la template
        TextView textView = (TextView) v.findViewById(R.id.textView);
        //Hacer un set de la informacion del elementoActual en los elementos de la interfaz del usuario.
        textView.setText(elementoActual.getTexto());

        return v;
    }
}
