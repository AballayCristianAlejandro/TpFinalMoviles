package com.example.plantilla.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.plantilla.R;

public class MainActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etPassword;
    private Button btBoton;
    private MainActivityViewModel vm ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        inicializar();

        vm.getResultadoMutable1().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String mensaje) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Advertencia...!!!")
                        .setMessage(mensaje)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });
        vm.getOkMutable().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Intent i = new Intent(getApplicationContext(), MenuNavegable.class);
                startActivity(i);
            }
        });
    }

    public void inicializar(){

        etUsuario=findViewById(R.id.etUsuario);
        etPassword =findViewById(R.id.etPassword);
        btBoton = findViewById(R.id.btBoton);
        btBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.verificarDatos(etUsuario.getText().toString(),etPassword.getText().toString());
            }
        });
    }
}