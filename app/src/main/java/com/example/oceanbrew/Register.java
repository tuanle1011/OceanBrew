package com.example.oceanbrew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://oceanbrew-7e5b2-default-rtdb.firebaseio.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        final EditText username = findViewById(R.id.ed_email_signup);
        final EditText nickname = findViewById(R.id.ed_nickname);
        final EditText pass = findViewById(R.id.ed_pass_signup);
        final EditText confirmpass = findViewById(R.id.ed_passconfirm_signup);
        final Button register = findViewById(R.id.btn_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String usernameTxt = username.getText().toString();
                final String nicknameTxt = nickname.getText().toString();
                final String passTxt = pass.getText().toString();
                final String conpassTxt = confirmpass.getText().toString();

                if(usernameTxt.isEmpty() || nicknameTxt.isEmpty() || passTxt.isEmpty()){
                    Toast.makeText(Register.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else if (!passTxt.equals(conpassTxt)){
                    Toast.makeText(Register.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("account").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(usernameTxt)){
                                Toast.makeText(Register.this,"Username already registerd",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                databaseReference.child("account").child(usernameTxt).child("nickname").setValue(nicknameTxt);
                                databaseReference.child("account").child(usernameTxt).child("password").setValue(passTxt);

                                Toast.makeText(Register.this, "User register successfully", Toast.LENGTH_SHORT).show();


                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

    }


}