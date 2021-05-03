package com.example.plantilla.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.plantilla.R;
import com.example.plantilla.modelo.Inmueble;
import com.example.plantilla.ui.Inmuebles.Inmuebles;

import java.util.ArrayList;
import java.util.List;

public class InmueblesAdapter extends RecyclerView.Adapter<InmueblesAdapter.ViewHolderInmmuebles>implements View.OnClickListener {
    private Inmuebles context;
    List<Inmueble> listainmueble ;
    private View.OnClickListener listener;

    public InmueblesAdapter(Inmuebles context, List<Inmueble> listainmueble) {
        this.listainmueble = listainmueble;
        this.context = context;
    }

    @NonNull
    @Override
    public InmueblesAdapter.ViewHolderInmmuebles onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_inmuebles,null,false);
       view.setOnClickListener(this);

        return new ViewHolderInmmuebles(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InmueblesAdapter.ViewHolderInmmuebles holder, int position) {


        holder.etdireccion.setText(listainmueble.get(position).getDireccion());
        holder.etprecio.setText(listainmueble.get(position).getUso());

        Glide
                .with(context)
                .load(listainmueble.get(position).getImagen())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.evimage);

    }

    @Override
    public int getItemCount() {
        return listainmueble.size();

    }

    public  void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        if (listener != null){

            listener.onClick(v);
        }
    }


    public class ViewHolderInmmuebles extends RecyclerView.ViewHolder {

        TextView etdireccion, etprecio;
        ImageView evimage;
        public ViewHolderInmmuebles(@NonNull View itemView) {
            super(itemView);
            etdireccion= (TextView) itemView.findViewById(R.id.iddireccion);
            etprecio = (TextView) itemView.findViewById(R.id.idiprecio);
            evimage= (ImageView) itemView.findViewById(R.id.idimage);
        }
    }
}
