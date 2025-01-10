package com.example.routetogether;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdaptadorRuta extends ArrayAdapter<Ruta> {
    Context ctx;
    int layoutTemplate;
    List<Ruta> rutas;

    public AdaptadorRuta(@NonNull Context context, int resource, @NonNull List<Ruta> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent,false);
        Ruta rutaActual = rutas.get(position);
    }

}
