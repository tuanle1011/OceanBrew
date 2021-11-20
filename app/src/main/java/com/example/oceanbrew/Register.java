package com.example.oceanbrew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText email_re,pass_re;
    Button register;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        matching();
        auth = FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String semail = email_re.getText().toString().trim();
                String spass = pass_re.getText().toString().trim();
                if (TextUtils.isEmpty(semail)){
                    Toast.makeText(getApplicationContext(),"Email Requied",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(spass)){
                    Toast.makeText(getApplicationContext(),"Password Requied",Toast.LENGTH_LONG).show();
                    return;
                }
                auth.createUserWithEmailAndPassword(semail,spass).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(getApplicationContext(),"Create Account complete",Toast.LENGTH_LONG).show();
                        if (!task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Create Account failed",Toast.LENGTH_LONG).show();
                            Log.d("Error",task.toString());
                        }
                        else {
                            startActivity(new Intent(Register.this,Login.class));
                            finish();
                        }
                    }
                });
            }
        });
    }

    private void matching() {
        email_re = (EditText) findViewById(R.id.ed_email);
        pass_re = (EditText) findViewById(R.id.ed_pass);
        register = (Button) findViewById(R.id.btn_register);
    }
}