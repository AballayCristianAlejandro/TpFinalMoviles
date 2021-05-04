package com.example.plantilla.ui.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.plantilla.R;
import com.example.plantilla.ui.MenuNavegable;
import com.example.plantilla.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private EditText etUsuario;
    private EditText etPassword;
    private Button btBoton;
    private MainActivityViewModel vm ;
    private SensorManager manager;
    private List<Sensor> sensores;
    private LeerSesores leerSesores;


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

    @Override
    protected void onResume() {
        super.onResume();
         manager = (SensorManager) getSystemService(SENSOR_SERVICE);
         sensores = manager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensores.size()>0){
            manager.registerListener(leerSesores,sensores.get(0),SensorManager.SENSOR_DELAY_GAME);
        }
        leerSesores =  new LeerSesores();
    }

    @Override
    protected void onStop() {
        super.onStop();
        manager.unregisterListener(leerSesores);
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


    private  class LeerSesores implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent event) {

            float X = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }
}