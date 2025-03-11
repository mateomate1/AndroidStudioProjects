package com.example.examen2ev_mariogarcia.misFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.examen2ev_mariogarcia.R;

public class CalculoNotaFragment extends Fragment {

    private EditText etPractica1, etPractica2, etExamen;
    private Switch switchRedondear;
    private Button btnCalcular, btnBorrar;
    private TextView tvResultado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculo_nota, container, false);

        etPractica1 = view.findViewById(R.id.etPractica1);
        etPractica2 = view.findViewById(R.id.etPractica2);
        etExamen = view.findViewById(R.id.etExamen);
        switchRedondear = view.findViewById(R.id.switchRedondear);
        btnCalcular = view.findViewById(R.id.btnCalcular);
        btnBorrar = view.findViewById(R.id.btnBorrar);
        tvResultado = view.findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(v -> calcularNota());
        btnBorrar.setOnClickListener(v -> borrarDatos());

        return view;
    }

    private void calcularNota() {
        try {
            double nota1 = Double.parseDouble(etPractica1.getText().toString());
            double nota2 = Double.parseDouble(etPractica2.getText().toString());
            double notaExamen = Double.parseDouble(etExamen.getText().toString());

            if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10 || notaExamen < 0 || notaExamen > 10) {
                tvResultado.setText("Las notas deben estar entre 0 y 10");
                return;
            }

            double media = (nota1 + nota2 + notaExamen) / 3;

            if (switchRedondear.isChecked()) {
                media = Math.round(media);
            }

            tvResultado.setText(String.format("Nota media: %.2f", media));
        } catch (NumberFormatException e) {
            tvResultado.setText("Por favor, introduce valores válidos");
        }
    }

    private void borrarDatos() {
        etPractica1.setText("");
        etPractica2.setText("");
        etExamen.setText("");
        tvResultado.setText("");
    }
}
