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

    public void  onClick (View view) {
        Bundle b = new Bundle();
        int status = 0;
        b.putInt("status", status);
        Intent i = new Intent(Planes.this, Cotizador.class);
        i.putExtras(b);
        startActivity(i);
    }
}



