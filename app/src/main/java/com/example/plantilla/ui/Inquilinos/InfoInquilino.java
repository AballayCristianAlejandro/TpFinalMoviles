package com.example.plantilla.ui.Inquilinos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.viewmodel.InfoInquilinoViewModel;
import com.example.plantilla.R;

public class InfoInquilino extends Fragment {
    private EditText etcodigo, etnombre,etapellido,etdni,etemail,ettelefono,etgarante,ettefonogarante;
    private Inquilinos inquilinos;
    private InfoInquilinoViewModel vm;

    public static InfoInquilino newInstance() {
        return new InfoInquilino();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(InfoInquilinoViewModel.class);
        View root = inflater.inflate(R.layout.info_inquilino_fragment, container, false);
        inicializavista(root);
        vm.getInquilinosMutable().observe(getViewLifecycleOwner(), new Observer<Inquilino>() {
            @Override
            public void onChanged(Inquilino inquilino) {
                        etcodigo.setText(inquilino.getIdInquilino()+"");
                        etnombre.setText(inquilino.getNombre());
                        etapellido.setText(inquilino.getApellido());
                        etdni.setText(inquilino.getDNI()+"");
                        etemail.setText(inquilino.getEmail());
                        ettelefono.setText(inquilino.getTelefono());
                        etgarante.setText(inquilino.getNombreGarante());
                        ettefonogarante.setText(inquilino.getTelefonoGarante());

            }
        });
      //  vm.leerDatos(inquilinos);
        return root;
    }

    public void inicializavista (View root){
        etcodigo = root.findViewById(R.id.etcodigo);
        etnombre = root.findViewById(R.id.etnombre);
        etapellido = root.findViewById(R.id.etapellido);
        etdni= root.findViewById(R.id.etdni);
        etemail = root.findViewById(R.id.etemail);
        ettelefono = root.findViewById(R.id.ettelefono);
        etgarante = root.findViewById(R.id.etgarante);
        ettefonogarante = root.findViewById(R.id.ettelefonogarante);


    }
   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = new ViewModelProvider(this).get(InfoInquilinoViewModel.class);
        // TODO: Use the ViewModel
    }*/

}