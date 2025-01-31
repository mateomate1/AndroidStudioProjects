package com.example.notificacionbasica;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int CODIGO_RESPUESTA = 200;
    private static final String CHANNEL_ID = "Notificacion";
    private static final int NOTIFICATION_ID = 1;
    Button boton;
    NotificationCompat.Builder notificacion;

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
        boton = findViewById(R.id.btnNotificacion);
        boton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                createNotification();
            }
        });
    }

    @SuppressLint("MissingPermission")
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void createNotification() {
        notificacion = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        notificacion.setSmallIcon(R.drawable.ic_android_black_24dp);
        notificacion.setContentTitle("Notificacion Android");
        notificacion.setContentText("Repasa las practicas android");
        notificacion.setColor(Color.RED);
        notificacion.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificacion.setVibrate(new long[]{1000, 1000, 1000, 1000});
        notificacion.setDefaults(Notification.DEFAULT_SOUND);
        NotificationManagerCompat notificationManagerCompat;
        notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        verificarPermisos();
        notificationManagerCompat.notify(NOTIFICATION_ID, notificacion.build());
    }
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Notificacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void verificarPermisos() {
        List<String> permisos = new ArrayList<>();
        permisos.add(Manifest.permission.POST_NOTIFICATIONS);

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