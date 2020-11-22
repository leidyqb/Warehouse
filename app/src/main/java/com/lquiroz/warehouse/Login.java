package com.lquiroz.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText txtUsuario, txtPassword;
    Button btnEntrar;
    DAOUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtPassword = findViewById(R.id.txtPassword);
        btnEntrar =findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(this);

        dao=new DAOUsuario(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEntrar:
                String usu=txtUsuario.getText().toString();
                String pasw=txtPassword.getText().toString();
                if (usu.equals("")&&pasw.equals("")){
                    Toast.makeText(Login.this, "ERROR: CAMPOS VACIOS", Toast.LENGTH_SHORT).show();
                }else if (dao.login(usu,pasw)==1){
                    Usuario ux=dao.getUsuario(usu,pasw);
                    Toast.makeText(Login.this, "DATOS CORRECTOS", Toast.LENGTH_SHORT).show();
                    Intent i3= new Intent(Login.this,Cotizador.class);
                    i3.putExtra("ID", ux.getId());
                    startActivity(i3);
                    finish();
                }else{
                    Toast.makeText(Login.this, "EL USUARIO Y/O CONTRASEÑA SON INCORRECTOS", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}