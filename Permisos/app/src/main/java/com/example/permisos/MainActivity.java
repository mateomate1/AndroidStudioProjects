package com.example.permisos;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.Manifest;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int CODIGO_RESPUESTA = 200;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        verificarPermisos();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void verificarPermisos() {
        List<String> permisos = new ArrayList<>();
        permisos.add(Manifest.permission.SEND_SMS);
        permisos.add(Manifest.permission.INTERNET);
        permisos.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permisos.add(Manifest.permission.ACCESS_COARSE_LOCATION);

        List<String> request = new ArrayList<>();

        for (String permiso : permisos) {
            if (ContextCompat.checkSelfPermission(this,permiso) == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,permiso.toString()+" CONCEDIDO", Toast.LENGTH_SHORT).show();
            } else {
                request.add(permiso);
            }
        }
        if (!request.isEmpty()) {
            requestPermissions(request.toArray(new String[0]), CODIGO_RESPUESTA);
        }
    }
}