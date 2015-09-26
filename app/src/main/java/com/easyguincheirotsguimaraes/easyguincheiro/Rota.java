package com.easyguincheirotsguimaraes.easyguincheiro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Rota extends AppCompatActivity implements OnMapReadyCallback,GoogleApiClient.OnConnectionFailedListener, OnStreetViewPanoramaReadyCallback {

    protected GoogleMap mMap; // Might be null if Google Play services APK is not available.
    //protected GoogleMap errmap;
    private static final String TAG = "livroandroid";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rota);
        // Ativa a utilização do Maps IMPORTANTISSIMO!!!
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //setUpMapIfNeeded();
    }



    public void onMapReady(GoogleMap map) {

        //habilita botão da minha localização
        // Somente irá pegar a localização atual clicando no botão se tiver permissão para isso (LOCAL).
        //map.setMyLocationEnabled(true);

        //CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_BURNABY,BIND_IMPORTANT);// Distância da camera
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL); //Tipo do Mapa
        this.findViewById(R.id.mapView);
        // Marcador apontando para a USP
        LatLng sp = new LatLng(-23.599160080557642, -46.69948190000002);
        map.addMarker(new MarkerOptions().position(sp).title("Seu destino, clique na seta para traçar a rota."));
        map.moveCamera(CameraUpdateFactory.newLatLng(sp));

        // ---Pegando a localização maneira manual---
        LocationRequest nLocationRequest = new LocationRequest();
        nLocationRequest.setInterval(10000); // 10 segundos
        nLocationRequest.setFastestInterval(5000); //5 segundos
        nLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {

    }
}
