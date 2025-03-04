package com.app.examen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorContacto extends ArrayAdapter<Contacto> {
    Context context;
    int resource;
    List<Contacto> contactos = new ArrayList<>();
    public AdaptadorContacto(@NonNull Context context, int resource, @NonNull List<Contacto> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.contactos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }
        Contacto c = contactos.get(position);

        TextView nombre = (TextView) convertView.findViewById(R.id.textoNombre);
        TextView telefono = (TextView) convertView.findViewById(R.id.textoTelefono);
        TextView email = (TextView) convertView.findViewById(R.id.textoEmail);
        ImageView imagen = (ImageView) convertView.findViewById(R.id.imageView);

        nombre.setText(c.getNombre());
        telefono.setText(c.getTelefono());
        email.setText(c.getEmail());
        imagen.setImageResource(c.getResource());

        return convertView;
    }

}
