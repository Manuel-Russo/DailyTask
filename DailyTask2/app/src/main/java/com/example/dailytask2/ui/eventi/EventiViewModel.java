package com.example.dailytask2.ui.eventi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EventiViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public EventiViewModel()    {
        mText = new MutableLiveData<>();
        mText.setValue("questo è il fragment evento");
    }

    public LiveData<String> getText()   {
        return mText;
    }
}
