package com.lquiroz.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Detalle_Cotizador03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle__cotizador03);
    }

    public void onClick(View view) {
        Bundle b = new Bundle();
        int status = 0;
        b.putInt("status", status);
        Intent i = new Intent(Detalle_Cotizador03.this, Pagos.class);
        i.putExtras(b);
        startActivity(i);
    }
}