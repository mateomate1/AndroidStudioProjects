package com.example.examen1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityCalculo extends AppCompatActivity {

    private EditText inPractica1, inPractica2, inExamen;
    private Button btnCalcular, btnBorrarDatos;
    private TextView outResultado;
    private CheckBox checkRedondeo, checkExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculo);

        inPractica1 = findViewById(R.id.inPractica1);
        inPractica2 = findViewById(R.id.inPractica2);
        inExamen = findViewById(R.id.inExamen);

        outResultado = findViewById(R.id.outResultado);

        checkRedondeo = findViewById(R.id.checkRedondeo);
        checkExam = findViewById(R.id.checkExam);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnBorrarDatos = findViewById(R.id.btnBorrarDatos);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });

        btnBorrarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrarDatos();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void calcular(){
        String p1 = inPractica1.getText().toString().trim();
        String p2 = inPractica2.getText().toString().trim();
        String e = inExamen.getText().toString().trim();
        if (!p1.isEmpty()&&!p2.isEmpty()&&!e.isEmpty()){
            try {
                double
                        x = Double.parseDouble(p1),
                        y = Double.parseDouble(p2),
                        z = Double.parseDouble(e),
                        res = checkExam.isChecked()?((x + y) / 2 ): ((x + y + z) / 3);
                if (checkRedondeo.isChecked()) {
                    res = (double) Math.round(res);
                }
                outResultado.setText("Media: " + res);
            } catch (NumberFormatException i){
                outResultado.setText("Alguno de los valores no es un numero.");
            }
        }
    }

    private void borrarDatos(){
        inExamen.setText("");
        inPractica1.setText("");
        inPractica2.setText("");
        outResultado.setText("");
        checkRedondeo.setChecked(false);
        checkExam.setChecked(false);
    }

}