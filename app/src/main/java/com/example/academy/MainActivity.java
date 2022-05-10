package com.example.academy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {
    // Request Code para serem utilizados no gerenciamento das permissões
    private static final int REQUEST_LAST_LOCATION = 1;
    private static final int REQUEST_LOCATION_UPDATES = 2;

    // Classe das API Fused Location
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private LocationRequest mLocationRequest;
    private LocationCallback mLocationCallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Button get = (Button) findViewById(R.id.bt_get);
        get.setOnClickListener((View.OnClickListener) this);
        atualizarLastLocationView(null);
        atualizarLocationUpdatesView(null);
    }

    private void atualizarLocationUpdatesView(Location Location) {
        //TextView tv_lu = (TextView)findViewById(R.id.tv_currentLocation);
        String mens = "Dados da posição atual\n";
        if(Location!=null){
            mens+=String.valueOf("Latitude(graus)="+Location.getLatitude()+"\n")
                    +String.valueOf("Longitude(graus)="+Location+"\n");
        }

    }

    private void atualizarLastLocationView(Location Location) {

    }

    public void onClicke(View view){
        if(view.getId()==R.id.bt_get)
            lastLocation();
       /* if(view.getId()==R.id.bt_start)
            startLocationUpdates();
        if(view.getId()==R.id.bt_stop)
            stopLocationUpdates();*/
    }

    private void stopLocationUpdates() {

    }

    private void startLocationUpdates() {

    }

    private void lastLocation() {
        //Se o app tem permissão para acessar a ultima localização
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
            mFusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    atualizarLastLocationView(location);// processar a localização
                }
            });

        }else{
            //Solicite a permissão
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LAST_LOCATION);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[]permissions, int[]grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_LAST_LOCATION){
            //if(grantResults.length == 1 && grantResults[0] == PackageManager)
        }
    }

    public void onButtonClicked(View view) {

        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }

}