package com.example.foropancho;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foropancho.adapters.AdapterTipos;
import com.example.foropancho.model.Tipos;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ListaTipos extends AppCompatActivity {
    Context contexto;
    RecyclerView listaTipos;
    FloatingActionButton buttonAddTipo;
    AdapterTipos adapterTipos;
    FirebaseFirestore miFirestore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tipos);
        contexto = this;

        miFirestore = FirebaseFirestore.getInstance();

        listaTipos = findViewById(R.id.recyclerTipos);

        buttonAddTipo = findViewById(R.id.buttonAddTipo);

        buttonAddTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddTipo fragment = new AddTipo();
                fragment.show(getSupportFragmentManager(),"Navegar a fragment");
            }
        });

        listaTipos.setLayoutManager(new LinearLayoutManager(this));
        Query query = miFirestore.collection("Tipos");

        FirestoreRecyclerOptions<Tipos> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Tipos>().setQuery(query,Tipos.class).build();

        adapterTipos = new AdapterTipos(firestoreRecyclerOptions);
        adapterTipos.notifyDataSetChanged();

        listaTipos.setAdapter(adapterTipos);

        adapterTipos.setOnItemClickListener(new AdapterTipos.OnItemClickListener(){
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                Tipos tipos = documentSnapshot.toObject(Tipos.class);

                Intent intent = new Intent(ListaTipos.this, ListaPosts.class);
                intent.putExtra("Tipo",tipos.getTipo());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapterTipos.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterTipos.stopListening();
    }
}
