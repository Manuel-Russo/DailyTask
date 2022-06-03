package com.example.dailytask2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.dailytask2.MainActivity;
import com.example.dailytask2.ProdottoAdapter;
import com.example.dailytask2.R;
import com.example.dailytask2.Utility;
import com.example.dailytask2.ui.eventi.EventiFragment;

public class HomeFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layoutH = inflater.inflate(R.layout.fragment_home,container,false);
        CalendarView calendarView = layoutH.findViewById(R.id.calendario);
        calendarView.setOnDateChangeListener((calendarView1, i, i1, i2) -> {
            i1++;
            String stringai2="";
            String stringai1="";
            if(i2<10)    {
                stringai2 = "0" + i2;
            }
            else {
                stringai2 = "" + i2;
            }
            if (i1<10)  {
                stringai1 = "0" + i1;
            }
            else    {
                stringai1 = "" + i1;
            }
            String data = stringai2 + "-" + stringai1+ "-" + i;
            Utility.scaricaEvento(data);
            System.out.println("eventoGiornalieriInLista   " + EventiFragment.eventiGiornalieri.toString());
        });
        ListView lista = layoutH.findViewById(R.id.listaHome);
        MainActivity.adapterHome = new ProdottoAdapter(EventiFragment.eventiGiornalieri);
        lista.setAdapter(MainActivity.adapterHome);
        MainActivity.adapterHome.notifyDataSetChanged();
        return layoutH;
    }
}