package com.carog.formvalidation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvCreateAccount;
    String USERNAME, PASSWORD;
    int formsuccess;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvCreateAccount = findViewById(R.id.tvCreateAccount);
        
        btnLogin.setOnClickListener(this);
        tvCreateAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:

                formsuccess = 2;
                USERNAME = etUsername.getText().toString();
                PASSWORD = etPassword.getText().toString();
                if(USERNAME.equals("")){
                    etUsername.setError("this field is required");
                    formsuccess--;
            }
                if(PASSWORD.equals("")){
                    etPassword.setError("this field is required");
                    formsuccess--;
            }
            if (formsuccess == 2){
                Toast.makeText(this, "FORM VALIDATED", Toast.LENGTH_SHORT).show();
            }
                break;

            case R.id.tvCreateAccount:

                Intent signup = new Intent(this, SignupActivity.class);
                startActivity(signup);
        }
    }
}
