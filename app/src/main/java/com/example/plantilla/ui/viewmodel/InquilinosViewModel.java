package com.example.plantilla.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.request.ApiClient;
import com.example.plantilla.ui.Inquilinos.Inquilinos;

import java.util.ArrayList;
import java.util.List;

public class InquilinosViewModel extends ViewModel {

    private ApiClient api=new ApiClient();

    private MutableLiveData<List<Inmueble>>inmueblesalquiladosMutable;

    public LiveData<List<Inmueble>> getinmueblesAlquiladosMutable (){
        if (inmueblesalquiladosMutable == null){
            inmueblesalquiladosMutable = new MutableLiveData<>();
        }
        return inmueblesalquiladosMutable;
    };

    public void ObtenerInmuebleAlquilados(){
        ArrayList<Inmueble> inmu;
        inmu=api.obtenerPropiedadesAlquiladas();
        inmueblesalquiladosMutable.setValue(inmu);
    }

}