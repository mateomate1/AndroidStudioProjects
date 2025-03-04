package com.app.examen;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AzulFragment extends Fragment {
    int CODIGO_RESPUESTA = 200;
    private static final String CHANNEL_ID = "Notificacion";
    private static final int NOTIFICATION_ID = 1;
    Button boton;
    NotificationCompat.Builder notificacion;
    View v;
    public AzulFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_azul, container, false);
        boton = v.findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Toast.makeText(v.getContext(), "Si", Toast.LENGTH_SHORT).show();
                createNotificationChannel();
                createNotification();
            }
        });
        return v;
    }
    @SuppressLint("MissingPermission")
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void createNotification() {
        notificacion = new NotificationCompat.Builder(v.getContext(), CHANNEL_ID);
        notificacion.setSmallIcon(R.drawable.baseline_priority_high_24);
        notificacion.setContentTitle("¡Cuidado!");
        notificacion.setContentText(" Acabas de pulsar el botón de notificación de la aplicación de Mateo Ayarra");
        notificacion.setColor(Color.RED);
        notificacion.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificacion.setVibrate(new long[]{1000, 1000, 1000, 1000});
        notificacion.setDefaults(Notification.DEFAULT_SOUND);
        NotificationManagerCompat notificationManagerCompat;
        notificationManagerCompat = NotificationManagerCompat.from(v.getContext());
        verificarPermisos();
        notificationManagerCompat.notify(NOTIFICATION_ID, notificacion.build());
    }
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Notificacion";
            NotificationChannel notificationChannel = null;
            notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) v.getContext().getSystemService(v.getContext().NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void verificarPermisos() {
        List<String> permisos = new ArrayList<>();
        permisos.add(Manifest.permission.POST_NOTIFICATIONS);

        List<String> request = new ArrayList<>();

        for (String permiso : permisos) {
            if (ContextCompat.checkSelfPermission(v.getContext(),permiso) == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(v.getContext(),permiso.toString()+" CONCEDIDO", Toast.LENGTH_SHORT).show();
            } else {
                request.add(permiso);
            }
        }
        if (!request.isEmpty()) {
            requestPermissions(request.toArray(new String[0]), CODIGO_RESPUESTA);
        }
    }
}