package com.example.practicaservicio.servicios;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import java.util.List;

public class MiServicio extends Service implements LocationListener {

    private Context ctx;
    LocationManager locationManager;

    Location localizacion;
    boolean gpsActivo;
    TextView texto;
    Double latitud, longitud;
    public MiServicio(){
        super();
    }
    public MiServicio(Context c) {
        super();
        this.ctx = c;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }

    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {
        LocationListener.super.onLocationChanged(locations);
    }

    @Override
    public void onFlushComplete(int requestCode) {
        LocationListener.super.onFlushComplete(requestCode);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
    }

    public void setView(View v) {
        texto = (TextView) v;
        texto.setText("Coordenadas: " + latitud + ", " + longitud);
    }

    @SuppressLint("MissingPermission")
    public void getLocation() {
        try {
            locationManager = (LocationManager) this.ctx.getSystemService(LOCATION_SERVICE);
            gpsActivo = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {

        }
        if (gpsActivo) {
            locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER
                    , 1000 * 60
                    , 10
                    , this);
        }
        localizacion = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
        longitud = localizacion.getLongitude();
        latitud = localizacion.getLatitude();
    }
}
