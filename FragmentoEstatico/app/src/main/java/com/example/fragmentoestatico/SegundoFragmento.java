package com.example.fragmentoestatico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class SegundoFragmento extends Fragment {

    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_segundo_fragmento, container, false);
        imageView = view.findViewById(R.id.imageView);

        // Establecer la imagen inicial de tutifruti
        imageView.setImageResource(R.drawable.tutifruti);

        return view;
    }

    public void updateImage(int imageResource) {
        imageView.setImageResource(imageResource);
    }
}
