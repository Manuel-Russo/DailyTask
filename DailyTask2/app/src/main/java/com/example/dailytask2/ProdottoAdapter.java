package com.example.dailytask2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProdottoAdapter extends BaseAdapter    {
    ArrayList<Evento> lista;
    Context contesto;

    public ProdottoAdapter(ArrayList<Evento> lista, Context contesto) {
        this.lista = lista;
        this.contesto = contesto;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Evento getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)   {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.layout_evento, viewGroup, false);
        }
        TextView Data = view.findViewById(R.id.Data);
        TextView Nome = view.findViewById(R.id.Nome);
        TextView Descrizione = view.findViewById(R.id.Descrizione);
        Evento prodotto = lista.get(i);
        Nome.setText(prodotto.nome);
        Data.setText(prodotto.giorno+"/"+prodotto.mese+"/"+ prodotto.anno);
        Descrizione.setText(prodotto.descrizione);
        return view;
    }
}
