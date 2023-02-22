package com.example.foropancho;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foropancho.adapters.AdapterListaPosts;
import com.example.foropancho.model.Post;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class ListaPosts extends AppCompatActivity {
    Context context;
    RecyclerView listaPosts;
    AdapterListaPosts adapterListaPosts;
    FirebaseFirestore firebaseFirestore;
    FloatingActionButton buttonAddPost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_posts);
        context = this;

        firebaseFirestore = FirebaseFirestore.getInstance();

        listaPosts = findViewById(R.id.recyclerPosts);

        buttonAddPost = findViewById(R.id.buttonAddPost);

        buttonAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Tipo", getIntent().getStringExtra("Tipo"));
                AddPost fragment = new AddPost();
                fragment.setArguments(bundle);
                fragment.show(getSupportFragmentManager(),"Navegar a fragment");
            }
        });

        listaPosts.setLayoutManager(new LinearLayoutManager(this));

        CollectionReference postsRef = firebaseFirestore.collection("Posts");
        Query query = postsRef.whereEqualTo("Tipo", getIntent().getStringExtra("Tipo"));

        FirestoreRecyclerOptions<Post> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Post>().setQuery(query, Post.class).build();

        adapterListaPosts = new AdapterListaPosts(firestoreRecyclerOptions);
        adapterListaPosts.notifyDataSetChanged();

        listaPosts.setAdapter(adapterListaPosts);

    }


    @Override
    protected void onStart() {
        super.onStart();
        adapterListaPosts.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterListaPosts.stopListening();
    }
}
