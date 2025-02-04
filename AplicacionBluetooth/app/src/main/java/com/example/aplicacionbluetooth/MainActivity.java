package com.example.aplicacionbluetooth;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static int REQUEST_BLUETOOTH = 1;
    int CODIGO_RESPUESTA = 200;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BluetoothAdapter BTAdapter = BluetoothAdapter.getDefaultAdapter();
        if (BTAdapter == null){
            new AlertDialog.Builder(this)
                    .setTitle("No compatible")
                    .setMessage("Tu telefono no es compatible con BLUETOOTH")
                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            System.exit(0);
                        }
                    })
                    .setIcon(R.drawable.baseline_back_hand_24)
                    .show();
        }else {
            verificarPermisos();
            if (!BTAdapter.isEnabled()){
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_BLUETOOTH);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void verificarPermisos() {
        List<String> permisos = new ArrayList<>();
        permisos.add(Manifest.permission.BLUETOOTH);
        permisos.add(Manifest.permission.BLUETOOTH_ADMIN);
        permisos.add(Manifest.permission.BLUETOOTH_CONNECT);
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CODIGO_RESPUESTA){
            if (grantResults.length > 0){
                boolean permisosConcedidos = true;
                for (int result : grantResults){
                    if (result != PackageManager.PERMISSION_GRANTED){
                        permisosConcedidos = false;
                        break;
                    }
                }
                if (permisosConcedidos) {
                    Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permisos necesarios para funcionar", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}