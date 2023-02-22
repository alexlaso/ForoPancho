package com.example.foropancho.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foropancho.R;
import com.example.foropancho.model.Post;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class AdapterListaPosts extends FirestoreRecyclerAdapter<Post, AdapterListaPosts.ViewHolder> {
    private AdapterTipos.OnItemClickListener onItemClickListener;

    public AdapterListaPosts(@NonNull FirestoreRecyclerOptions<Post> options){super(options);}

    @Override
    public void onBindViewHolder(@NonNull AdapterListaPosts.ViewHolder holder, int position, @NonNull Post post) {
        holder.titulo.setText(post.getTituloPost());
        holder.autor.setText(post.getCreador());
        holder.desc.setText(post.getDescripcion());
    }

    @NonNull
    @Override
    public AdapterListaPosts.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post,parent, false);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo, autor, desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textViewTitulo);
            autor = itemView.findViewById(R.id.textViewAutor);
            desc = itemView.findViewById(R.id.textViewDesc);

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

    public void setOnItemClickListener(AdapterTipos.OnItemClickListener listener){
        this.onItemClickListener=listener;
    }
}
