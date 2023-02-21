package com.example.foropancho;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ListaTipos extends AppCompatActivity {
    Context contexto;
    private RecyclerView listaTipos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_tipos);
        contexto = this;

        listaTipos = findViewById(R.id.recyclerTipos);
    }
}
