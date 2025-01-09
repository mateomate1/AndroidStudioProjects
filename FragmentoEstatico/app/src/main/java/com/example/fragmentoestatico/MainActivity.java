package com.example.fragmentoestatico;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PrimerFragmento.OnItemSelectedListener {

    private SegundoFragmento segundoFragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        segundoFragmento = (SegundoFragmento) getSupportFragmentManager().findFragmentById(R.id.fragmentInferior);
    }

    @Override
    public void onItemSelected(int imageResource) {
        if (segundoFragmento != null) {
            segundoFragmento.updateImage(imageResource);
        }
    }
}
