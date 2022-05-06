package com.example.dailytask2.ui.settings;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dailytask2.LoginActivity;
import com.example.dailytask2.MainActivity;
import com.firebase.ui.auth.AuthUI;

public class SettingsViewModel extends ViewModel {

    private final MutableLiveData<String> notifiche;
    private final MutableLiveData<String> temaScuro;
    private final Switch switchNotifiche = null;

    public SettingsViewModel() {
        notifiche = new MutableLiveData<>();
        notifiche.setValue("notifiche");

        temaScuro = new MutableLiveData<>();
        temaScuro.setValue("Tema Scuro");

        /*assert switchNotifiche != null;
        switchNotifiche.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b)     {
                switchNotifiche.setText("ON");
            }
            else    {
                switchNotifiche.setText("OFF");
            }
        });*/
    }

    public MutableLiveData<String> getNotifiche() {
        return notifiche;
    }

    public MutableLiveData<String> getTemaScuro() {
        return temaScuro;
    }

    public Switch getSwitchNotifiche() {
        return switchNotifiche;
    }
}