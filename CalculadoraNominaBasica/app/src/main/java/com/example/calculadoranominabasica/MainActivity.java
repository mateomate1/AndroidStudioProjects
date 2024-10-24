package com.example.calculadoranominabasica;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final float pagoHora = 13.75f;
    private float pago;
    private EditText introDias, introHoras;
    private TextView valorPaga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Vincula los elementos de la interfaz
        introDias = findViewById(R.id.introDias);
        introHoras = findViewById(R.id.introHoras);
        valorPaga = findViewById(R.id.valorPaga);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);

        // Establece un listener para el botón de calcular
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPago();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        introDias = findViewById(R.id.introDias);
    }

    // Método para calcular el pago
    private void calcularPago() {
        // Obtén los valores de los EditText
        String diasString = introDias.getText().toString();
        String horasString = introHoras.getText().toString();

        // Convierte los valores a números
        int dias = diasString.isEmpty() ? 0 : Integer.parseInt(diasString);
        int horas = horasString.isEmpty() ? 0 : Integer.parseInt(horasString);

        // Calcula el pago
        pago = dias * horas * pagoHora;

        // Muestra el resultado en el TextView
        valorPaga.setText(String.format("Pago: %.2f €", pago));
    }

}