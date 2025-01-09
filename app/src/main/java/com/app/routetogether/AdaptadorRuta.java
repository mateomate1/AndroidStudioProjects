package com.app.routetogether;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdaptadorRuta extends ArrayAdapter<Ruta> {
    Context ctx;
    int layoutTemplate;
    List<Ruta> rutas;

    public AdaptadorRuta(@NonNull Context context, int resource, @NonNull List<Ruta> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.rutas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent,false);
        //Obtener la informacion del elemento de la lista
        Ruta rutaActual = rutas.get(position);

        //Rescatar los elementos  de la interfaz de usuario de la template

        ImageView imageView = v.findViewById(R.id.imageView);
        TextView textViewNombre = v.findViewById(R.id.Nombre);
        TextView textViewDireccionRecogida = v.findViewById(R.id.direccionRecogida);
        TextView textViewDireccionFinal = v.findViewById(R.id.direccionFinal);
        TextView textViewHoraRecogida = v.findViewById(R.id.HoraRecogida);
        TextView textViewLunes = v.findViewById(R.id.Lunes);
        TextView textViewMartes = v.findViewById(R.id.Martes);
        TextView textViewMiercoles = v.findViewById(R.id.Miercoles);
        TextView textViewJueves = v.findViewById(R.id.Jueves);
        TextView textViewViernes = v.findViewById(R.id.Viernes);
        TextView textViewSabado = v.findViewById(R.id.Sabado);
        TextView textViewDomingo = v.findViewById(R.id.Domingo);

        //Hacer un set de la informacion del elementoActual en los elementos de la interfaz del usuario.
        imageView.setImageResource(getImgID(rutaActual.getImgpath()));

        textViewNombre.setText(rutaActual.getNombre());
        textViewDireccionRecogida.setText(rutaActual.getDireccionRecogida());
        textViewDireccionFinal.setText(rutaActual.getDireccionFinal());
        textViewHoraRecogida.setText(rutaActual.getHora());

        // Cambiar el color de fondo para los días false en el array 'dias'
        if (!rutaActual.getDias()[0]) {
            textViewLunes.setTextColor(ctx.getResources().getColor(R.color.red));
        } else if (rutaActual.getDias()[0]) {
            textViewLunes.setTextColor(ctx.getResources().getColor(R.color.green));
        }

        if (!rutaActual.getDias()[1]) {
            textViewMartes.setTextColor(ctx.getResources().getColor(R.color.red));
        } else if (rutaActual.getDias()[1]) {
            textViewMartes.setTextColor(ctx.getResources().getColor(R.color.green));
        }

        if (!rutaActual.getDias()[2]) {
            textViewMiercoles.setTextColor(ctx.getResources().getColor(R.color.red));
        } else if (rutaActual.getDias()[2]) {
            textViewMiercoles.setTextColor(ctx.getResources().getColor(R.color.green));
        }

        if (!rutaActual.getDias()[3]) {
            textViewJueves.setTextColor(ctx.getResources().getColor(R.color.red));
        } else if (rutaActual.getDias()[3]) {
            textViewJueves.setTextColor(ctx.getResources().getColor(R.color.green));
        }

        if (!rutaActual.getDias()[4]) {
            textViewViernes.setTextColor(ctx.getResources().getColor(R.color.red));
        } else if (rutaActual.getDias()[4]) {
            textViewViernes.setTextColor(ctx.getResources().getColor(R.color.green));
        }

        if (!rutaActual.getDias()[5]) {
            textViewSabado.setTextColor(ctx.getResources().getColor(R.color.red));
        } else if (rutaActual.getDias()[5]) {
            textViewSabado.setTextColor(ctx.getResources().getColor(R.color.green));
        }

        if (!rutaActual.getDias()[6]) {
            textViewDomingo.setTextColor(ctx.getResources().getColor(R.color.red));
        } else if (rutaActual.getDias()[6]) {
            textViewDomingo.setTextColor(ctx.getResources().getColor(R.color.green));
        }


        return v;
    }

    public int getImgID(String nombre) {
        // Verifica el nombre y devuelve el ID del recurso de imagen
        if (nombre.equals("bici")) {
            return R.drawable.bici;
        } else if (nombre.equals("coche")) {
            return R.drawable.coche;
        } else if (nombre.equals("bus")) {
            return R.drawable.bus;
        } else if (nombre.equals("tren")) {
            return R.drawable.tren;
        } else if (nombre.equals("viaandante")) {
            return R.drawable.viaandante;
        } else {
            return R.drawable.otros;  // Valor por defecto si no coincide
        }
    }


}
