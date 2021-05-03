package com.example.plantilla.ui.Inmuebles;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.plantilla.R;
import com.example.plantilla.ui.viewmodel.InmueblesViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InformacionInmueble#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformacionInmueble extends Fragment {
    private EditText etnombre,etapellido,etmail,etcodigo,ettelefono,etgarante,ettelefonnogrante;

    private InmueblesViewModel vm;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InformacionInmueble() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InformacionInmueble.
     */
    // TODO: Rename and change types and number of parameters
    public static InformacionInmueble newInstance(String param1, String param2) {
        InformacionInmueble fragment = new InformacionInmueble();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(InmueblesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_informacion_inmueble, container, false);
       // inicializarVista(root);
       /* vm.getinmuebleMutable().observe(getViewLifecycleOwner(), new Observer<Inquilino>() {
            @Override
            public void onChanged(Inquilino inquilino) {
                etapellido.setText(inquilino.getApellido());
                etnombre.setText(inquilino.getNombre());
                etmail.setText(inquilino.getEmail());
                etcodigo.setText(inquilino.getIdInquilino() +"");
                etgarante.setText(inquilino.getNombreGarante());
                ettelefonnogrante.setText(inquilino.getTelefonoGarante());
                 ettelefono.setText(inquilino.getTelefono());

            }
        });*/
        //vm.leerDatos();
        return root;
    }

  /*  public void inicializarVista(View root) {

        etapellido = root.findViewById(R.id.etapellido);
        etnombre = root.findViewById(R.id.etnombre);
        etmail = root.findViewById(R.id.etmail);
        etcodigo = root.findViewById(R.id.etcodigo);
        etgarante = root.findViewById(R.id.etgarante);
        ettelefonnogrante = root.findViewById(R.id.ettelefonogarante);
        ettelefono = root.findViewById(R.id.ettelefono);
    }*/
}