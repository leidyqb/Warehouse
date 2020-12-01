package com.lquiroz.warehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class UbicacionActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        LatLng warehouse = new LatLng(-12.0765784, -77.0743252);
        mMap.addMarker(new MarkerOptions().position(warehouse).title("Warehouse")
                .icon(cambiarIcono(getApplicationContext(),R.drawable.shop)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(warehouse,16));

    }

    private BitmapDescriptor cambiarIcono(Context context, int id){
        Drawable imagen = ContextCompat.getDrawable(context,id);
        imagen.setBounds(0,0,imagen.getIntrinsicWidth(),imagen.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(imagen.getIntrinsicWidth(), imagen.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        imagen.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}