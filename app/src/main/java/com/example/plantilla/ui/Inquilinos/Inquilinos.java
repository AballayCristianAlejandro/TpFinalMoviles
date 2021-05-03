package com.example.plantilla.ui.Inquilinos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantilla.R;
import com.example.plantilla.adapter.InmueblesAlquiladosAdapter;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.ui.Inmuebles.Inmuebles;
import com.example.plantilla.ui.viewmodel.InmueblesViewModel;
import com.example.plantilla.ui.viewmodel.InquilinosViewModel;

import java.util.List;

public class Inquilinos extends Fragment {
    private EditText etdireccion,etprecio;
    private ImageView evimage;
    private InquilinosViewModel vm;
    private Inquilinos context= Inquilinos.this;
    RecyclerView recyclerInmueblesAlquildaos ;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        vm= new ViewModelProvider(this).get(InquilinosViewModel.class);

        View root = inflater.inflate(R.layout.fragment_inquilinos, container, false);
        inicializarvista(root);
        recyclerInmueblesAlquildaos= root.findViewById(R.id.recycleridinquilinos);
        recyclerInmueblesAlquildaos.setLayoutManager(new LinearLayoutManager(getContext()));
        vm.getinmueblesAlquiladosMutable().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                InmueblesAlquiladosAdapter adapter = new InmueblesAlquiladosAdapter(context,inmuebles);

                recyclerInmueblesAlquildaos.setAdapter(adapter);


            }
        });
        vm.ObtenerInmuebleAlquilados();
        return root;
    }

    public void inicializarvista(View root){
        etdireccion = root.findViewById(R.id.iddireccion);
        etprecio = root.findViewById(R.id.idiprecio);
        evimage = root.findViewById(R.id.idimage);
    }
}