package com.example.plantilla.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Propietario;
import com.example.plantilla.request.ApiClient;

import java.util.ArrayList;

public class SlideshowViewModel extends ViewModel {

    private ApiClient api=new ApiClient();
    private ArrayList<Inmueble> inmu;
    private MutableLiveData<Inmueble> inmuebleMutable;

    public LiveData<Inmueble> getinmuebleMutable (){
        if (inmuebleMutable == null){
            inmuebleMutable = new MutableLiveData<>();
        }
        return inmuebleMutable;
    };

    public void ObtenerInmueble(){

        inmu=api.obtenerPropiedadesAlquiladas();
    }
}