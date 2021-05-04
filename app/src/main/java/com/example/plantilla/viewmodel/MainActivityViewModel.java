package com.example.plantilla.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.plantilla.modelo.Propietario;
import com.example.plantilla.request.ApiClient;

public class MainActivityViewModel extends ViewModel {



    public MutableLiveData<String> resultadoMutable1;
    public MutableLiveData<Boolean> okMutable;


    public LiveData<String> getResultadoMutable1() {
        if(resultadoMutable1 == null){
            resultadoMutable1 = new MutableLiveData<>();
        }

        return resultadoMutable1;
    }
    public LiveData<Boolean> getOkMutable() {
        if(okMutable == null){
            okMutable = new MutableLiveData<>();
        }

        return okMutable;
    }
    public void verificarDatos (String usuario, String password) {

        if (usuario != null || password != null && usuario.length() > 0 && password.length() > 0){
            ApiClient api = new ApiClient();

            Propietario prop = api.login(usuario, password);
            if ((prop == null)) {
                resultadoMutable1.setValue("Usuario y contraseña incorrecto");
            } else {
                okMutable.setValue(true);
            }
        }else {
            resultadoMutable1.setValue("Los campos no pueden estar vacios");
        }

    }
}