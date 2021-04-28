package com.example.plantilla.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Propietario;
import com.example.plantilla.request.ApiClient;

public class HomeViewModel extends ViewModel {
    private ApiClient api=new ApiClient();
    private Propietario prop, propietarioModificado;
    private MutableLiveData<Propietario> propietarioMutable;

    public LiveData<Propietario> getPropietarioMutable (){
        if (propietarioMutable == null){
            propietarioMutable = new MutableLiveData<>();
        }
        return propietarioMutable;
    };
    public void leerDatos(){


        prop = api.obtenerUsuarioActual();

        propietarioMutable.setValue(prop);


    }
    public void actualizarDatos(Propietario propietaio){

         api.actualizarPerfil( propietaio) ;

    }
}