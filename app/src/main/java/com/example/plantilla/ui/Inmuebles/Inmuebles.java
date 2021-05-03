package com.example.plantilla.ui.Inmuebles;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantilla.R;
import com.example.plantilla.adapter.InmueblesAdapter;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.ui.viewmodel.InmueblesViewModel;

import java.util.List;

public class Inmuebles extends Fragment {
    private EditText etdireccion,etprecio;
    private ImageView evimage;
    private InmueblesViewModel vm;
    private Inmuebles context= Inmuebles.this;
    RecyclerView recyclerInmuebles ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

          vm = new ViewModelProvider(this).get(InmueblesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inmuebles, container, false);
        inicializarvista(root);
        recyclerInmuebles= root.findViewById(R.id.recyclerid);
        recyclerInmuebles.setLayoutManager(new LinearLayoutManager(getContext()));

        vm.getinmuebleMutable().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(final List<Inmueble> inmueble) {
                InmueblesAdapter adapter = new InmueblesAdapter(context,inmueble);
                adapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(),"Seleccion"+ inmueble.get(recyclerInmuebles.getChildAdapterPosition(v)).getDireccion(),Toast.LENGTH_LONG).show();
                 /*  InformacionInmueble fragment =  new InformacionInmueble();
                   FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                   transaction.replace(R.id.,fragment);
                   transaction.addToBackStack(null);
                   transaction.commit();*/
                        //startActivity(new Intent(getActivity(),InformacionInmueble.class));

                    }
                });


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