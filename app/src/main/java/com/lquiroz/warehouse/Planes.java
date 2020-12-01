package com.lquiroz.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class Planes extends AppCompatActivity {

    Button btnUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planes);
        asignarReferencias();
    }

    private void asignarReferencias(){
        btnUbicacion = findViewById(R.id.btnUbicacion);
        btnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Planes.this,UbicacionActivity.class);
                startActivity(intent);

            }
        });
    }

    public void  llamar (View view){
        Bundle b = new Bundle();
        int status = 0;
        b.putInt("status", status);
        Intent i = new Intent(Planes.this, Cotizando.class);
        i.putExtras(b);
        startActivity(i);
    }

}


