package com.example.plantilla.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel vm;
    RecyclerView recyclerInmuebles ;
    ArrayList<Inmueble> listaInmuebles ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

          vm = new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        listaInmuebles = new ArrayList<>();
        recyclerInmuebles= (RecyclerView) root.findViewById(R.id.recyclerid);
        recyclerInmuebles.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarInmueble();

        return root;
    }
    public void llenarInmueble(){


    }

}