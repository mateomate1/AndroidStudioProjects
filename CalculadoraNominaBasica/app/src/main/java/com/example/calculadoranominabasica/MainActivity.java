package com.example.calculadoranominabasica;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final float pagoHora = 13.75f;
    private float desc;
    private float pagoNum = 0;
    private String pago = "";
    private EditText introDias, introHoras;
    private CheckBox checkBoxPago, checkBoxDescuento;
    private TextView valorPaga, valorDescuento;
    private RadioButton radioButtonSi, radioButtonNo;

    private boolean round = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        introDias = findViewById(R.id.introDias);
        introHoras = findViewById(R.id.introHoras);
        checkBoxPago = findViewById(R.id.checkBoxPago);
        checkBoxDescuento = findViewById(R.id.checkBoxDescuento);
        valorPaga = findViewById(R.id.valorPaga);
        valorDescuento = findViewById(R.id.valorDescuento);
        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        Button buttonBorrar = findViewById(R.id.buttonBorrar);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioButtonSi = findViewById(R.id.RadioButtonSi);
        radioButtonNo = findViewById(R.id.RadioButtonNo);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPago();
            }
        });

        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrar();
            }
        });

        checkBoxPago.setOnCheckedChangeListener((buttonView, isCheked)->{
            if (isCheked)
                valorPaga.setText(pago);
            else
                valorPaga.setText("");
        });

        checkBoxDescuento.setOnCheckedChangeListener((buttonView, isCheked)->{
            if (isCheked) {
                desc = pagoNum > 2000 ? (float) (pagoNum * 0.1) : 0;
                valorDescuento.setText(print(desc));
            }
            else
                valorDescuento.setText("");
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            round = checkedId == R.id.RadioButtonSi;
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

        // Capturar excepcion en caso de no ser un numero
        try {
            // Convierte los valores a números decimales
            float dias = diasString.isEmpty() ? 0 : Float.parseFloat(diasString);
            float horas = horasString.isEmpty() ? 0 : Float.parseFloat(horasString);

            // Calcula el pago
            pagoNum = dias * horas * pagoHora;
            pago = print(pagoNum);
        } catch (NumberFormatException e) {
            pago = "ERROR...";
        }
    }

    private void borrar(){
        introDias.setText("");
        introHoras.setText("");
        valorPaga.setText("");
    }

    private String print(float val){
        if (round)
            val = Math.round(val);
        return String.format("%.2f €", val);
    }


}