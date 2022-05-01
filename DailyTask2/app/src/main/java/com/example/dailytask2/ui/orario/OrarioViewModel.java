package com.example.dailytask2.ui.orario;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrarioViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> mAltroTesto;

    public OrarioViewModel() {
        mText = new MutableLiveData<>();
        mAltroTesto = new MutableLiveData<>();
        mText.setValue("Orario Scolastico");
        mAltroTesto.setValue("altro");
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getAltroTesto() {
        return mAltroTesto;
    }
}