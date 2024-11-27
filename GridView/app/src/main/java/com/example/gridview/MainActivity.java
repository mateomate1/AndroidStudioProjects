package com.example.gridview;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        String[] titles = {"Titulo Ejemplo 1", "Titulo Ejemplo 2", "Titulo Ejemplo 3", "Titulo Ejemplo 4"};
        String[] subtitles = {"Subtitulo Ejemplo 1", "Subtitulo Ejemplo 2", "Subtitulo Ejemplo 3", "Subtitulo Ejemplo 4"};
        int[] images = {R.drawable.avatar, R.drawable.avatar, R.drawable.avatar, R.drawable.avatar};  // Usa imágenes adecuadas

        CustomAdapter customAdapter = new CustomAdapter(this, titles, subtitles, images);
        gridView.setAdapter(customAdapter);
    }
}