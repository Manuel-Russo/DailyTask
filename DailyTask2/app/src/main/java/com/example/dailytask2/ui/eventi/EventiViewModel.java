package com.example.dailytask2.ui.eventi;

import android.widget.BaseAdapter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dailytask2.MainActivity;
import com.example.dailytask2.ProdottoAdapter;

public class EventiViewModel extends ViewModel {
    private final MutableLiveData<BaseAdapter> mLista;
    static ProdottoAdapter prodottoAdapter;

    public EventiViewModel()    {
        mLista = new MutableLiveData<>();
        mLista.setValue(prodottoAdapter);
    }

    public MutableLiveData<BaseAdapter> getmLista() {
        return mLista;
    }

    public static ProdottoAdapter getProdottoAdapter() {
        return prodottoAdapter;
    }
}
