package com.example.foropancho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class Login_Activity extends AppCompatActivity {
    EditText editTextCorreo, editTextPW;
    Button buttonLoginLogin;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        this.setTitle("Login");
        firebaseAuth = FirebaseAuth.getInstance();

        editTextCorreo = findViewById(R.id.editTextCorreoLogin);
        editTextPW = findViewById(R.id.editTextPWLogin);

        buttonLoginLogin = findViewById(R.id.buttonLoginLogin);

        buttonLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editTextCorreo.getText().toString().isEmpty() && !editTextPW.getText().toString().isEmpty()){
                    iniciarSesion(editTextCorreo.getText().toString(),editTextPW.getText().toString());
                }else{
                    Toast.makeText(Login_Activity.this,"Los campos deben estar rellenos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void iniciarSesion(String correo, String pw){
        firebaseAuth.signInWithEmailAndPassword(correo,pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(Login_Activity.this, ListaTipos.class));
                }
            }
        });
    }
}
