package com.example.dailytask2.ui.eventi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dailytask2.Utility;
import com.example.dailytask2.databinding.FragmentEventiBinding;

public class EventiFragment extends Fragment {
    private FragmentEventiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)  {
        EventiViewModel eventiViewModel = new ViewModelProvider(this).get(EventiViewModel.class);
        binding = FragmentEventiBinding.inflate(inflater,container,false);
        final ListView lista = binding.lista;
        Utility.scaricaProdotti();
        eventiViewModel.getmLista().observe(getViewLifecycleOwner(), lista::setAdapter);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}