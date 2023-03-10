package com.example.foropancho.adapters;

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
import com.google.firebase.firestore.DocumentSnapshot;

public class AdapterTipos extends FirestoreRecyclerAdapter<Tipos, AdapterTipos.ViewHolder> {
    private OnItemClickListener onItemClickListener;
    public AdapterTipos(@NonNull FirestoreRecyclerOptions<Tipos> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdapterTipos.ViewHolder holder, int position, @NonNull Tipos tipos) {
        holder.Tipo.setText(tipos.getTipo());
        holder.Descripcion.setText(tipos.getDescripcion());
    }

    @NonNull
    @Override
    public AdapterTipos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tipos, parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Tipo, Descripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Tipo = itemView.findViewById(R.id.textViewTipo);
            Descripcion = itemView.findViewById(R.id.textViewDescTipo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && onItemClickListener!=null){
                        onItemClickListener.onItemClick(getSnapshots().getSnapshot(position), position);
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener=listener;
    }
}