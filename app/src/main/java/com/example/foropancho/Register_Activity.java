package com.example.foropancho;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register_Activity extends AppCompatActivity {
    EditText editTextNombre, editTextCorreo, editTextNick, editTextPW;
    Button registrar;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextCorreo = findViewById(R.id.editTextCorreo);
        editTextNick = findViewById(R.id.editTextNick);
        editTextPW = findViewById(R.id.editTextPW);

        registrar = findViewById(R.id.buttonRegistrarAct);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editTextCorreo.getText().toString().isEmpty() && !editTextPW.getText().toString().isEmpty()/* && !editTextNombre.getText().toString().isEmpty() && !editTextNick.getText().toString().isEmpty()*/){
                    registrarUser(editTextCorreo.getText().toString(),editTextPW.getText().toString());
                    //subirDatosUser(editTextNombre.getText().toString(),editTextNick.getText().toString());
                }else{
                    Toast.makeText(Register_Activity.this,"Los campos deben estar rellenos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registrarUser(String user, String pw){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(user, pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Register_Activity.this, "Usuario registrado correctamente",Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    Toast.makeText(Register_Activity.this,"Error en el registro",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
