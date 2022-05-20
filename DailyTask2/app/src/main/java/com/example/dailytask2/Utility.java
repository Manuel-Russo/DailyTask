package com.example.dailytask2;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dailytask2.ui.eventi.EventiFragment;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Utility    {

    public static void scaricaProdotti(ArrayList<Evento> eventi)     {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("/evento").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                eventi.add(new Evento((HashMap<String, Object>) Objects.requireNonNull(snapshot.getValue())));
                MainActivity.adapter.notifyDataSetChanged();
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
    public static void scaricaEvento(int anno, int mese, int giorno)   {            //By Paola <3
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("/evento/");
        mDatabase.orderByChild("anno").equalTo(anno).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mDatabase.orderByChild("mese").equalTo(mese).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        mDatabase.orderByChild("giorno").equalTo(giorno).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                HashMap<String, HashMap<String, Object>> hashMapHashMap = (HashMap<String, HashMap<String, Object>>) Objects.requireNonNull(snapshot.getValue());
                                for (Map.Entry<String, HashMap<String, Object>> stringHashMapEntry : hashMapHashMap.entrySet()) {
                                    HashMap<String, Object> hashMap = stringHashMapEntry.getValue();
                                    System.out.println(hashMap);
                                    EventiFragment.eventiGiornalieri.add(new Evento(String.valueOf(hashMap.get("nome")), Objects.requireNonNull(Long.getLong(String.valueOf(hashMap.get("giorno")))), Objects.requireNonNull(Long.getLong(String.valueOf(hashMap.get("mese")))), Objects.requireNonNull(Long.getLong(String.valueOf(hashMap.get("anno")))), Boolean.getBoolean(String.valueOf(hashMap.get("notifica"))), String.valueOf(hashMap.get("descrizione"))));
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
