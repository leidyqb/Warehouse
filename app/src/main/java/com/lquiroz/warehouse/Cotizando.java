package com.lquiroz.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cotizando extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizando);
        Button one = findViewById(R.id.button1);
        one.setOnClickListener(this); // calling onClick() method
        Button two =  findViewById(R.id.button2);
        two.setOnClickListener(this);
        Button three =  findViewById(R.id.button3);
        three.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Bundle b1 = new Bundle();
                int status1 = 0;
                b1.putInt("status", status1);
                Intent i1 = new Intent(Cotizando.this, Detalle_Cotizador01.class);
                i1.putExtras(b1);
                startActivity(i1);
                break;
            case R.id.button2:
                Bundle b2 = new Bundle();
                int status2 = 0;
                b2.putInt("status", status2);
                Intent i2 = new Intent(Cotizando.this, Detalle_Cotizador02.class);
                i2.putExtras(b2);
                startActivity(i2);
                break;
            case R.id.button3:
                Bundle b3 = new Bundle();
                int status = 0;
                b3.putInt("status", status);
                Intent i3 = new Intent(Cotizando.this, Detalle_Cotizador03.class);
                i3.putExtras(b3);
                startActivity(i3);
                break;
            default:
                break;
        }
    }
}