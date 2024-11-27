package com.example.listviewpersonalizado;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class MiAdaptadorEjemplo extends ArrayAdapter<Ejemplo> {
    public MiAdaptadorEjemplo(@NonNull Context context, int resource, @NonNull List<Ejemplo> objects) {
        super(context, resource, objects);
    }
}
