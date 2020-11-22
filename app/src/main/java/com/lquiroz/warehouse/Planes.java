package com.lquiroz.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Planes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planes);
    }

    public void  llamar (View view){
        Intent intent = new Intent(this, Cotizador.class);
        startActivity(intent);
    }

}


