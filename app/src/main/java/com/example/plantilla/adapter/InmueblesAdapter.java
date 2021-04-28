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

public class InmueblesAdapter extends RecyclerView.Adapter<InmueblesAdapter.ViewHolderInmmuebles> {

    ArrayList<Inmueble> listainmueble ;

    public InmueblesAdapter(ArrayList<Inmueble> listainmueble) {
        this.listainmueble = listainmueble;
    }

    @NonNull
    @Override
    public InmueblesAdapter.ViewHolderInmmuebles onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_inmuebles,null,false);
        return new ViewHolderInmmuebles(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InmueblesAdapter.ViewHolderInmmuebles holder, int position) {


        holder.etdireccion.setText(listainmueble.get(position).getDireccion());
        holder.etprecio.setText(listainmueble.get(position).getUso());
       // holder.ivimage.setImageResource( listainmueble.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return listainmueble.size();
    }

    public class ViewHolderInmmuebles extends RecyclerView.ViewHolder {

        TextView etdireccion, etprecio;
        ImageView ivimage;
        public ViewHolderInmmuebles(@NonNull View itemView) {
            super(itemView);
            etdireccion= (TextView) itemView.findViewById(R.id.iddireccion);
            etprecio = (TextView) itemView.findViewById(R.id.idiprecio);
            ivimage= (ImageView) itemView.findViewById(R.id.idimage);
        }
    }
}
