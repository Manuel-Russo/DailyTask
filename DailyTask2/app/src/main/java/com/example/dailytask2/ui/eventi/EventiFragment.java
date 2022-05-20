package com.example.dailytask2.ui.eventi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dailytask2.Evento;
import com.example.dailytask2.MainActivity;
import com.example.dailytask2.ProdottoAdapter;
import com.example.dailytask2.R;
import com.example.dailytask2.Utility;

import java.util.ArrayList;

public class EventiFragment extends Fragment {
    public static ArrayList<Evento> eventi = new ArrayList<>();
    public static ArrayList<Evento> eventiGiornalieri = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)  {
        Utility.scaricaProdotti(eventi);
        View layoutE = inflater.inflate(R.layout.fragment_eventi,container,false);
        ListView lista = layoutE.findViewById(R.id.lista);
        MainActivity.adapter=new ProdottoAdapter(eventi);
        lista.setAdapter(MainActivity.adapter);
        return layoutE;
    }
}