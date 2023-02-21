package com.example.foropancho.adapters;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foropancho.R;
import com.example.foropancho.model.Tipos;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class AdapterTipos extends FirestoreRecyclerAdapter<Tipos, AdapterTipos.ViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdapterTipos(@NonNull FirestoreRecyclerOptions<Tipos> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterTipos.ViewHolder holder, int position, @NonNull Tipos model) {
        holder.Titulo.setText(model.getTitulo());
        holder.Descripcion.setText(model.getDescripcion());
    }

    @NonNull
    @Override
    public AdapterTipos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tipos, parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Titulo, Descripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Titulo = itemView.findViewById(R.id.textViewTipo);
            Descripcion = itemView.findViewById(R.id.textViewDescTipo);
        }
    }
}