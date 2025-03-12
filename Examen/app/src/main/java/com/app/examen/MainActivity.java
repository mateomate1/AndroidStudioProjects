package com.app.examen;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction transaction;
    Fragment fragmentoSaludo, fragmentoLista, fragmentoAzul, fragmentoCalculo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fragmentoSaludo = new SaludoFragment();
        fragmentoLista = new ListadoFragment();
        fragmentoAzul = new AzulFragment();
        fragmentoCalculo = new CalculoFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, fragmentoSaludo).commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu mimenu) {
        getMenuInflater().inflate(R.menu.activity_menu, mimenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        transaction = getSupportFragmentManager().beginTransaction();
        if(id == R.id.opcnListado){
            transaction.replace(R.id.contenedor, fragmentoLista);
            transaction.addToBackStack(null);
        } else if (id == R.id.opcNotificacion){
            transaction.replace(R.id.contenedor, fragmentoAzul);
            transaction.addToBackStack(null);
        } else if (id == R.id.opcAlarma){
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 12);
            calendar.set(Calendar.MINUTE, 30);
            calendar.set(Calendar.SECOND, 0);
            Toast.makeText(this, "Entrando a la creacion de la alarma", Toast.LENGTH_SHORT).show();
            setAlarm(1, calendar.getTimeInMillis(),this);
        } else if (id == R.id.opcCalculo){
            transaction.replace(R.id.contenedor, fragmentoCalculo);
            transaction.addToBackStack(null);
        }
        transaction.commit();
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    public static void setAlarm(int i, Long timestamp, Context ctx){
        AlarmManager alarmManager = (AlarmManager) ctx.getSystemService(ALARM_SERVICE);
        Toast.makeText(ctx, "Entrando al alarm reciever", Toast.LENGTH_SHORT).show();
        Intent alarmIntent = new Intent(ctx, AlarmReceiver.class);
        PendingIntent pendingIntent;
        pendingIntent = PendingIntent.getBroadcast(ctx, i, alarmIntent, PendingIntent.FLAG_ONE_SHOT);
        alarmIntent.setData((Uri.parse("custom://" + System.currentTimeMillis())));
        alarmManager.set(AlarmManager.RTC_WAKEUP, timestamp, pendingIntent);
    }

}