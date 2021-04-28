package com.example.plantilla.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;

public class SlideshowFragment extends Fragment {
    private EditText etdireccion,etprecio;
    private ImageView evimage;
    private SlideshowViewModel vm, pp;
    RecyclerView recyclerInmuebles ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

          vm = new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        inicializarvista(root);
        recyclerInmuebles= root.findViewById(R.id.recyclerid);

        vm.getinmuebleMutable().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {
                etdireccion.setText(inmueble.getDireccion());
                etprecio.setText(inmueble.getPrecio()+"");
               // evimage.setImageResource(inmueble.getImagen());
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