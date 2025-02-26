package com.example.ejemplobdd.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
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
    public Contactos verContacto(int id){
        DBAyudante dbAyudante = new DBAyudante(context);
        SQLiteDatabase db = dbAyudante.getWritableDatabase();

        Contactos contacto = null;
        Cursor cursorContactos = null;

        cursorContactos = db.rawQuery("SELECT * FROM "+DATABASE_TABLE+" WHERE id = "+id+" LIMIT 1", null);
        if (cursorContactos.moveToFirst()){
                contacto = new Contactos();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setNombre(cursorContactos.getString(1));
                contacto.setTelefono(cursorContactos.getString(2));
                contacto.setCorreo_electronico(cursorContactos.getString(3));
        }
        cursorContactos.close();
        return contacto;
    }
    public boolean editarContacto(int id, @NonNull String nombre, @NonNull String telefono, @NonNull String correo_electronico){
        boolean correcto = false;
        DBAyudante dbAyudante = new DBAyudante(context);
        SQLiteDatabase db = dbAyudante.getWritableDatabase();
        try{
            //db.execSQL("UPDATE "+DATABASE_TABLE+" SET nombre = '"+nombre+"', telefono = '"+telefono+"', correo_electronico = '"+correo_electronico+"' WHERE id = '"+id+"'");
            StringBuilder query = new StringBuilder("UPDATE " + DATABASE_TABLE + " SET ");
            ArrayList<String> updates = new ArrayList<>();

            if (!nombre.trim().isEmpty()) {
                updates.add("nombre = '" + nombre + "'");
            }
            if (!telefono.trim().isEmpty()) {
                updates.add("telefono = '" + telefono + "'");
            }
            if (!correo_electronico.trim().isEmpty()) {
                updates.add("correo_electronico = '" + correo_electronico + "'");
            }

            if (!updates.isEmpty()) {
                query.append(String.join(", ", updates));
                query.append(" WHERE id = '").append(id).append("'");
                db.execSQL(query.toString());
            }

            correcto = true;
        } catch (Exception e){
            e.toString();
            correcto = false;
        }finally {
            db.close();
        }
        return correcto;
    }
    public boolean eliminarContacto(int id){
        boolean correcto = false;
        DBAyudante dbAyudante = new DBAyudante(context);
        SQLiteDatabase db = dbAyudante.getWritableDatabase();
        try {
            db.execSQL("DELETE FROM "+DATABASE_TABLE+" WHERE id = '"+id+"'");
            correcto = true;
        } catch (Exception e){
            e.toString();
            correcto = false;
        } finally {
            db.close();
        }
        return correcto;
    }
}
