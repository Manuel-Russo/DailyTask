package com.example.dailytask2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dailytask2.Evento;
import com.example.dailytask2.MainActivity;
import com.example.dailytask2.ProdottoAdapter;
import com.example.dailytask2.R;
import com.example.dailytask2.Utility;
import com.example.dailytask2.ui.eventi.EventiFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layoutH = inflater.inflate(R.layout.fragment_home,container,false);
        CalendarView calendarView = layoutH.findViewById(R.id.calendario);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Utility.scaricaEvento(i,i1,i2);
            }
        });
        ListView lista = layoutH.findViewById(R.id.listaHome);
        MainActivity.adapterHome = new ProdottoAdapter(EventiFragment.eventiGiornalieri);
        lista.setAdapter(MainActivity.adapterHome);
        return layoutH;
    }
}