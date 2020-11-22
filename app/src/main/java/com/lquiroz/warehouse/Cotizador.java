package com.lquiroz.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;

import java.util.IdentityHashMap;

public class Cotizador extends AppCompatActivity implements View.OnClickListener{
    TextView nombre;

    int id=0;
    Usuario u;
    DAOUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizador);
        nombre=(TextView)findViewById(R.id.nameuser);

        Bundle b=getIntent().getExtras();
        id=b.getInt("Id");
        dao=new DAOUsuario(this);
        u=dao.getUsuarioById(id);

    }

    @Override
    public void onClick(View view) {
            Bundle b = new Bundle();
            int status = 0;
            b.putInt("status", status);
            Intent i = new Intent(Cotizador.this, Detalle_Cotizador01.class);
            i.putExtras(b);
            startActivity(i);
        }
}