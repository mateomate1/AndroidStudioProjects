package com.example.calculadorabasica;

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

    private EditText num1, num2;
    private TextView resultado;
    private Button buttonMas, buttonRes, buttonMul, buttonDiv, buttonBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        resultado = findViewById(R.id.resultado);
        buttonMas = findViewById(R.id.buttonMas);
        buttonRes = findViewById(R.id.buttonRes);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonBorrar = findViewById(R.id.buttonBorrar);

        buttonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular("+");
            }
        });
        buttonRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular("-");
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular("*");
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular("/");
            }
        });
        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText("");
            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void calcular(String operacion) {
        String numero1 = num1.getText().toString();
        String numero2 = num2.getText().toString();

        if (!numero1.isEmpty() && !numero2.isEmpty()) {
            double n1 = Double.parseDouble(numero1);
            double n2 = Double.parseDouble(numero2);
            double res = 0;

            switch (operacion) {
                case "+":
                    res = n1 + n2;
                    break;
                case "-":
                    res = n1 - n2;
                    break;
                case "*":
                    res = n1 * n2;
                    break;
                case "/":
                    if (n2 != 0) {
                        res = n1 / n2;
                    } else {
                        resultado.setText("Error: Div 0");
                        return;
                    }
                    break;
                default:
                    resultado.setText("Operación no válida");
                    return;
            }
            resultado.setText(String.valueOf(res));
        } else {
            resultado.setText("Por favor, ingrese ambos números");
        }
    }

}