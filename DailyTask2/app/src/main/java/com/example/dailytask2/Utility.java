package com.example.dailytask2;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dailytask2.ui.eventi.EventiViewModel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class Utility    {

    public static void scaricaProdotti()     {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("evento").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                MainActivity.eventi.add(new Evento((HashMap<String, Object>) Objects.requireNonNull(snapshot.getValue())));
                EventiViewModel.getProdottoAdapter().notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.d("xxxx","Evento modificato");
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                Log.d("xxxx","Evento rimosso");
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.d("xxxx","Evento mosso");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("xxxx","Database rimosso");
            }
        });

    }

    public static void scriviDatabase(String nome, String giorno, String mese, String anno, boolean notifica, String descrizione)     {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Evento p = new Evento(nome, Integer.parseInt(giorno), Integer.parseInt(mese), Integer.parseInt(anno), notifica, descrizione);
        mDatabase.child("/evento").push().setValue(p.serializzaSuFirebase());
    }
}
