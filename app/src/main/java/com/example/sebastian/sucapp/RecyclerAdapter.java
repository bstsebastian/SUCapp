package com.example.sebastian.sucapp;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sebastian.sucapp.entities.Asignatura;

import java.util.List;

/**
 * Created by sebastian on 4/10/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AsignaturasViewHolder> {
    List<Asignatura> asignaturas;
    public RecyclerAdapter(List<Asignatura> asignaturas){
        this.asignaturas = asignaturas;
    }
    @Override
    public AsignaturasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        AsignaturasViewHolder viewHolder = new AsignaturasViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AsignaturasViewHolder holder, int position) {
        holder.tvTitle.setText(asignaturas.get(position).getMateria());
        holder.tvDescription.setText(asignaturas.get(position).getProfesor());

    }

    @Override
    public int getItemCount() {
        return asignaturas.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class AsignaturasViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle,tvDescription, id;
        public CardView cardView;
        public AsignaturasViewHolder(View itemView){
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            tvTitle = (TextView)itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView)itemView.findViewById(R.id.tvDescription);
        }

    }

}
