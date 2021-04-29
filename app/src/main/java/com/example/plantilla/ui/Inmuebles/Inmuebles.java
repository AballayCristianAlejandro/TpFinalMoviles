package com.example.plantilla.ui.Inmuebles;

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
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantilla.R;
import com.example.plantilla.adapter.InmueblesAdapter;
import com.example.plantilla.modelo.Inmueble;

import java.util.List;

public class Inmuebles extends Fragment {
    private EditText etdireccion,etprecio;
    private ImageView evimage;
    private InmueblesViewModel vm;
    RecyclerView recyclerInmuebles ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

          vm = new ViewModelProvider(this).get(InmueblesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inmuebles, container, false);
        inicializarvista(root);
        recyclerInmuebles= root.findViewById(R.id.recyclerid);

        vm.getinmuebleMutable().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmueble) {
                InmueblesAdapter adapter = new InmueblesAdapter(inmueble);

                recyclerInmuebles.setAdapter(adapter);
            }
        });

        vm.ObtenerInmueble();
        return root;
    }

    public void inicializarvista(View root){
        etdireccion = root.findViewById(R.id.iddireccion);
        etprecio = root.findViewById(R.id.idiprecio);
         evimage = root.findViewById(R.id.idimage);
    }
}