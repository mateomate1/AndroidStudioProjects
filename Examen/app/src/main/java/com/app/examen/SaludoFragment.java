package com.app.examen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SaludoFragment extends Fragment {

    public SaludoFragment() {
        // Constructor vacío necesario para el fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla el layout para este fragment
        return inflater.inflate(R.layout.fragment_saludo, container, false);
    }
}
