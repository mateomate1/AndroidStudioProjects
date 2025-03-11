package com.app.examen;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public class NotificationService extends IntentService {

    private static final String CHANNEL_ID = "AlarmChannel";

    public NotificationService() {
        super("NotificationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Crear el canal de notificación si la versión de Android es 8.0 o superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Alarma Notification",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("Notificaciones para las alarmas");
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }

        // Crear la notificación sin sonido
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("¡Alarma Activada!")
                .setContentText("Es hora de la alarma. ¡Reacciona!")
                .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)  // Icono de la notificación
                .setAutoCancel(true)
                .setVibrate(new long[]{0, 500, 1000})  // Vibración
                .build();

        // Mostrar la notificación en la barra de estado
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);  // ID de notificación
    }
}
