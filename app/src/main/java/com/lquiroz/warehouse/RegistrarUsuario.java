package com.lquiroz.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarUsuario extends AppCompatActivity implements View.OnClickListener {
    EditText us,pas,nom,ape,corr,dni,cel,dir,pos;
    Button reg,log;
    DAOUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        us=findViewById(R.id.txtusuario);
        pas=findViewById(R.id.txtcontra);
        nom=findViewById(R.id.txtnombre);
        ape=findViewById(R.id.txtapellido);
        corr=findViewById(R.id.txtcorreo);
        dni=findViewById(R.id.txtdni);
        cel=findViewById(R.id.txtcelular);
        dir=findViewById(R.id.txtdireccion);
        pos=findViewById(R.id.txtcodpostal);
        reg=findViewById(R.id.btnregistrar);
        log=findViewById(R.id.btnlogin2);
        reg.setOnClickListener(this);
        log.setOnClickListener(this);
        dao=new DAOUsuario(this);



    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnregistrar:
                Usuario u=new Usuario();
                u.setUsuario(us.getText().toString());
                u.setContraseña(us.getText().toString());
                u.setNombre(us.getText().toString());
                u.setApellidos(us.getText().toString());
                u.setCorreo(us.getText().toString());
                u.setDni(us.getText().length());
                u.setCelular(us.getText().length());
                u.setDireccion(us.getText().toString());
                u.setCodPostal(us.getText().length());
                       if(!u.isNull()){
                           Toast.makeText(this,"ERROR: CAMPOS VACIOS",Toast.LENGTH_LONG).show();
                       }else if(dao.insertUsuario(u)){
                           Toast.makeText(this,"REGISTRO EXITOSO",Toast.LENGTH_LONG).show();
                           Intent i2 = new Intent(RegistrarUsuario.this,MainActivity.class);
                           startActivity(i2);
                       }else{
                           Toast.makeText(this,"EL USUARIO YA SE ENCUENTRA REGISTRADO",Toast.LENGTH_LONG).show();
                       }
                break;
            case R.id.btnlogin2:
                Intent i = new Intent(RegistrarUsuario.this,Login.class);
                startActivity(i);
                break;
        }

    }
}