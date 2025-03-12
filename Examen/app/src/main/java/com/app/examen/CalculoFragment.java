package com.app.examen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class CalculoFragment extends Fragment {
    EditText practica1, practica2, examen;
    TextView media;
    Button btnBorrar, btnCalcular;
    CheckBox checkBox;
    double notaNumero = 0;

    public CalculoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calculo, container, false);
        practica1 = v.findViewById(R.id.num1);
        practica2 = v.findViewById(R.id.num2);
        examen = v.findViewById(R.id.num3);
        media = v.findViewById(R.id.media);
        btnBorrar = v.findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBox.setChecked(false);
                practica1.setText("");
                practica2.setText("");
                examen.setText("");
                media.setText("");
                notaNumero = 0;
            }
        });
        btnCalcular = v.findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
        checkBox = v.findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                darNota();
            }
        });
        return v;
    }
    public void calcular() {
        if (!(practica1.getText().toString().isEmpty() || practica2.getText().toString().isEmpty() || examen.getText().toString().isEmpty())) {
            double practica1Value = Double.parseDouble(practica1.getText().toString());
            double practica2Value = Double.parseDouble(practica2.getText().toString());
            double examenValue = Double.parseDouble(examen.getText().toString());
            notaNumero = (practica1Value + practica2Value + examenValue)/3;
            darNota();
        }
    }

    public void darNota(){
        if (checkBox.isChecked()){
            media.setText(((int) notaNumero) +"");
        } else {
            media.setText(notaNumero+"");
        }
    }

}