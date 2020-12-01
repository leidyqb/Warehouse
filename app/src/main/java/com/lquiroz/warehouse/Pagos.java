package com.lquiroz.warehouse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;

public class Pagos extends AppCompatActivity {

    CardForm cardForm;
    Button pagar;
    AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagos);

        cardForm = findViewById(R.id.card_form);
        pagar = findViewById(R.id.btnBuy);
        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .setup(Pagos.this);
        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardForm.isValid()) {
                    alertBuilder = new AlertDialog.Builder(Pagos.this);
                    alertBuilder.setTitle("Confirmar antes de pagar");
                    alertBuilder.setMessage("Número de tarjeta: " + cardForm.getCardNumber() + "\n" +
                            "Fecha de expiración: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                            "CVV: " + "***" + "\n" +
                            "Codigo Postal: " + cardForm.getPostalCode() + "\n" +
                            "Número de celular: " + cardForm.getMobileNumber());
                    alertBuilder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Toast.makeText(Pagos.this, "Gracias por su compra", Toast.LENGTH_LONG).show();
                        }
                    });
                    alertBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();

                } else {
                    Toast.makeText(Pagos.this, "Por favor, complete el formulario", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
