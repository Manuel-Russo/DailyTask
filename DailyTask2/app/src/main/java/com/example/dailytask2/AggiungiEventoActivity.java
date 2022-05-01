package com.example.dailytask2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AggiungiEventoActivity extends AppCompatActivity {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switchNotifica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi_evento);
        EditText editText = findViewById(R.id.editNome);
        EditText dateText = findViewById(R.id.editTextDate);
        switchNotifica = (Switch) findViewById(R.id.switchNotifica);
        switchNotifica.setOnCheckedChangeListener((compoundButton, b) -> {
            Toast toast;
            if(b)     {
                toast = Toast.makeText(AggiungiEventoActivity.this, "on", Toast.LENGTH_SHORT);
            }
            else    {
                toast = Toast.makeText(AggiungiEventoActivity.this, "off", Toast.LENGTH_SHORT);
            }
            toast.show();
        });
        EditText descrizione = findViewById(R.id.editDescrizione);
        Button conferma = findViewById(R.id.conferma);
        conferma.setOnClickListener(view -> {
            finish();
            Toast.makeText(AggiungiEventoActivity.this,"Elemento Salvato",Toast.LENGTH_SHORT).show();
            });
    }
}