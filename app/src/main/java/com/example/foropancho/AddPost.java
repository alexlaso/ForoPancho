package com.example.foropancho;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddPost  extends DialogFragment {
    EditText editTextAddTipoNombre, editTextAddTipoDesc;
    Button buttonAddTipoAdd;
    private FirebaseFirestore miBBDD;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_tipo, container, false);
        miBBDD = FirebaseFirestore.getInstance();

        editTextAddTipoNombre = v.findViewById(R.id.editTextAddTipoNombre);
        editTextAddTipoDesc = v.findViewById(R.id.editTextAddTipoDesc);

        buttonAddTipoAdd = v.findViewById(R.id.buttonAddTipoAdd);

        buttonAddTipoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextAddTipoNombre.getText().toString().isEmpty() && !editTextAddTipoDesc.getText().toString().isEmpty()) {
                    addPost(editTextAddTipoNombre.getText().toString(), editTextAddTipoDesc.getText().toString(), miBBDD);
                }
            }
        });

        return v;

    }

    public void addPost(String nombre, String desc, FirebaseFirestore miBBDD){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        Map<String,Object> map = new HashMap<>();
        map.put("Creador", firebaseAuth.getCurrentUser().getEmail());
        map.put("Tipo",getArguments().getString("Tipo"));
        map.put("Titulo", nombre);
        map.put("Descripcion", desc);

        miBBDD.collection("Posts").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                getFragmentManager().beginTransaction().remove(AddPost.this).commit();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("TAG","ERROR AL CREAR EL POST");
            }
        });
    }
}


