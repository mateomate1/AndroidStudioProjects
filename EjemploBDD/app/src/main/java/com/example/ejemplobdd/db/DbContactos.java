package com.example.ejemplobdd.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.ejemplobdd.entidad.Contactos;

import java.util.ArrayList;

public class DbContactos extends DBAyudante{
    Context context;
    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarContacto(String nombre, String telefono, String correo_electronico){
        long id = 0;
        try{
            DBAyudante dbAyudante = new DBAyudante(context);
            SQLiteDatabase db = dbAyudante.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("correo_electronico", correo_electronico);
            id = db.insert(DATABASE_TABLE, null, values);
        } catch (Exception e){
            e.toString();
        }
        return id;
    }
    public ArrayList<Contactos> mostrarContactos(){
        DBAyudante dbAyudante = new DBAyudante(context);
        SQLiteDatabase db = dbAyudante.getWritableDatabase();
        ArrayList<Contactos> listaContactos = new ArrayList<>();
        Contactos contacto = null;
        Cursor cursorContactos = null;
        cursorContactos = db.rawQuery("SELECT * FROM "+DATABASE_TABLE, null);
        if (cursorContactos.moveToFirst()){
            do {
                contacto = new Contactos();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setNombre(cursorContactos.getString(1));
                contacto.setTelefono(cursorContactos.getString(2));
                contacto.setCorreo_electronico(cursorContactos.getString(3));
                listaContactos.add(contacto);
            }while (cursorContactos.moveToNext());
        }
        cursorContactos.close();
        return listaContactos;
    }
}
