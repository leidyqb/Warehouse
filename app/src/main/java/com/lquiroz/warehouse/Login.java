package com.lquiroz.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText txtUsuario, txtPassword;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsuario = findViewById(R.id.txtUsuario);
        txtPassword = findViewById(R.id.txtPassword);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtUsuario.getText().toString().equals("") || txtPassword.getText().toString().equals("")){
                    Toast toast = Toast.makeText(Login.this, "Debes Completar todos los campos", Toast.LENGTH_LONG);
                }
                else {
                    Intent intent = new Intent(Login.this,Cotizador.class);
                    startActivity(intent);
                }
            }
        });
    }
}