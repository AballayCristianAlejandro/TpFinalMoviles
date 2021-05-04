package com.example.plantilla.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.modelo.Inquilino;
import com.example.plantilla.modelo.Propietario;
import com.example.plantilla.request.ApiClient;

public class InfoInquilinoViewModel extends ViewModel {


    private ApiClient api=new ApiClient();
    private Inquilino inquilino;
    private MutableLiveData<Inquilino> InquilinoMutable;

    public LiveData<Inquilino> getInquilinosMutable (){
        if (InquilinoMutable == null){
            InquilinoMutable = new MutableLiveData<>();
        }
        return InquilinoMutable;
    };
    public void leerDatos(Inmueble inmueble){


        inquilino = api.obtenerInquilino(inmueble);
        InquilinoMutable.setValue(inquilino);


    }
}