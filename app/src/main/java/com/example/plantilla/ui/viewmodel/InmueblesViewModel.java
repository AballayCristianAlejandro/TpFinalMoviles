package com.example.plantilla.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class InmueblesViewModel extends ViewModel {

    private ApiClient api=new ApiClient();

    private MutableLiveData<List<Inmueble>>inmuebleMutable;

    public LiveData<List<Inmueble>> getinmuebleMutable (){
        if (inmuebleMutable == null){
            inmuebleMutable = new MutableLiveData<>();
        }
        return inmuebleMutable;
    };

    public void ObtenerInmueble(){
        ArrayList<Inmueble> inmu;
        inmu=api.obtnerPropiedades();
        inmuebleMutable.setValue(inmu);
    }
}