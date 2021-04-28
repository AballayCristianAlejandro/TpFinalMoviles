package com.example.plantilla.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Propietario;

public class HomeFragment extends Fragment {

    private EditText etnombre, etapellido, etmail, etcodigo, etdni, etcontrasenia, ettelefono;
    private HomeViewModel vm;
    private Button bteditar;
    private int orden =1;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        vm = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        inicializarVista(root);
        vm.getPropietarioMutable().observe(getViewLifecycleOwner(), new Observer<Propietario>() {

            @Override
            public void onChanged(final Propietario propietario) {
                etapellido.setText(propietario.getApellido());
                etnombre.setText(propietario.getNombre());
                etmail.setText(propietario.getEmail());
                etcodigo.setText(propietario.getId()+"");
                etdni.setText(propietario.getDni()+"");
                etcontrasenia.setText(propietario.getContraseña());
                ettelefono.setText(propietario.getTelefono());

                bteditar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            habilitar ();
                           vm.actualizarDatos(propietario);
                    }
                });
            }
        });

        vm.leerDatos();
        return root;
    }
     private void habilitar (){
         etapellido.setEnabled(true);
         etnombre.setEnabled(true);
         ettelefono.setEnabled(true);
         etmail.setEnabled(true);
         etdni.setEnabled(true);
         etcontrasenia.setEnabled(true);
     }
     private  void desabilitar (){
         etapellido.setEnabled(false);
         etnombre.setEnabled(false);
         ettelefono.setEnabled(false);
         etmail.setEnabled(false);
         etdni.setEnabled(false);
         etcontrasenia.setEnabled(false);
     }
    private void inicializarVista(View root) {
        etapellido = root.findViewById(R.id.etapellido);
        etnombre = root.findViewById(R.id.etnombre);
        etmail = root.findViewById(R.id.etmail);
        etcodigo = root.findViewById(R.id.etcodigo);
        etdni = root.findViewById(R.id.etdni);
        etcontrasenia = root.findViewById(R.id.etcontasenia);
        ettelefono = root.findViewById(R.id.ettelefono);
        bteditar = root.findViewById(R.id.bteditar);
       /* bteditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (orden){

                    case 1 : {
                        habilitar();

                        orden++;
                        break;
                    }
                    case 2 : {
                        vm.actualizarDatos();
                        desabilitar ();
                        orden--;
                        break;
                    }

                }
            }
        });*/


    }
}