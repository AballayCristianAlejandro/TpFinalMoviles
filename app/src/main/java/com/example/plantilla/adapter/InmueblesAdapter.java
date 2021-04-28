package com.example.plantilla.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;

import java.util.ArrayList;

public class InmueblesAdapter extends RecyclerView.Adapter<InmueblesAdapter.ViewHolderInmuebles> {

    ArrayList<Inmueble> listaInmuebles ;
    private View.OnClickListener listener;
    public InmueblesAdapter(ArrayList<Inmueble> listaInmuebles) {
        this.listaInmuebles = listaInmuebles;
    }

    @NonNull
    @Override
    public InmueblesAdapter.ViewHolderInmuebles onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_inmuebles,null,false);

        view.setOnClickListener((View.OnClickListener) this);


        return new ViewHolderInmuebles(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InmueblesAdapter.ViewHolderInmuebles holder, int position) {

    }

    @Override
    public int getItemCount() {

            return listaInmuebles.size();
    }



    public class ViewHolderInmuebles extends RecyclerView.ViewHolder {
        TextView etiNombre, etiInfo;
        ImageView ivimage;

        public ViewHolderInmuebles(@NonNull View itemView) {
            super(itemView);

            etiNombre= (TextView) itemView.findViewById(R.id.idnombre);
            etiInfo = (TextView) itemView.findViewById(R.id.idinfo);
            ivimage= (ImageView) itemView.findViewById(R.id.idimage);

        }
    }
}
