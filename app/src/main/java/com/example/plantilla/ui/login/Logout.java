package com.example.plantilla.ui.login;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plantilla.viewmodel.LogoutViewModel;
import com.example.plantilla.R;
import com.example.plantilla.viewmodel.MainActivityViewModel;

public class Logout extends Fragment {

    private LogoutViewModel vm;

    public static Logout newInstance() {
        return new Logout();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.logout_fragment, container, false);
        vm = new ViewModelProvider(this).get(LogoutViewModel.class);

        new AlertDialog.Builder(getContext())
                .setTitle("Cierre de secion")
                .setMessage("Esta seguro que desea cerrar la sesion ?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();

        return root;
    }
   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LogoutViewModel.class);
        // TODO: Use the ViewModel
    }*/

}