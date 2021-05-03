package com.example.plantilla.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.ui.Inmuebles.Inmuebles;
import com.example.plantilla.ui.Inquilinos.Inquilinos;

import java.util.List;

public class InmueblesAlquiladosAdapter extends RecyclerView.Adapter<InmueblesAlquiladosAdapter.ViewHolderInmmueblesAlquilados>{

    private Inquilinos context;
    List<Inmueble> listainmueblesAlquilado;

    public InmueblesAlquiladosAdapter(Inquilinos context, List<Inmueble> listainmueblesAlquilado) {
        this.context = context;
        this.listainmueblesAlquilado = listainmueblesAlquilado;
    }

    @NonNull
    @Override
    public InmueblesAlquiladosAdapter.ViewHolderInmmueblesAlquilados onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_inmuebles_alquilados,null,false);
        return new ViewHolderInmmueblesAlquilados (view);
    }

    @Override
    public void onBindViewHolder(@NonNull InmueblesAlquiladosAdapter.ViewHolderInmmueblesAlquilados holder, int position) {

        holder.etdireccion.setText(listainmueblesAlquilado.get(position).getDireccion());
        holder.etprecio.setText(listainmueblesAlquilado.get(position).getUso());

        Glide
                .with(context)
                .load(listainmueblesAlquilado.get(position).getImagen())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.evimage);

    }

    @Override
    public int getItemCount() {
        return listainmueblesAlquilado.size();
    }

    public class ViewHolderInmmueblesAlquilados extends RecyclerView.ViewHolder {
        TextView etdireccion, etprecio;
        ImageView evimage;

        public ViewHolderInmmueblesAlquilados(@NonNull View itemView) {
            super(itemView);

            etdireccion= (TextView) itemView.findViewById(R.id.iddireccion);
            etprecio = (TextView) itemView.findViewById(R.id.idiprecio);
            evimage= (ImageView) itemView.findViewById(R.id.idimage);
        }
    }
}
