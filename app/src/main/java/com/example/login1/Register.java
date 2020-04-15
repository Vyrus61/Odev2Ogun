package com.example.login1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    private static String name,email,password;

    public static String getName() {
        return name;
    }

    public static String getPassword() {
        return password;
    }

    public static String getEmail() {
        return email;
    }

    public static final String EXTRA_TEXT="com.example.application.login1.EXTRA_TEXT";
    EditText inputName;
    EditText inputEmail;
    EditText inputPassword;

    Button btnCreate;


    private Toolbar actionbarRegister;

    public void init(){
        actionbarRegister=(Toolbar) findViewById(R.id.actionbarRegister);
        setSupportActionBar(actionbarRegister);
        getSupportActionBar().setTitle("Hesap Olustur");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputName=(EditText) findViewById(R.id.txtUsername);
        inputEmail=(EditText) findViewById(R.id.txtEmail);
        inputPassword=(EditText) findViewById(R.id.txtPassword);

        btnCreate=(Button) findViewById(R.id.btnSendUser);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=inputName.getText().toString();
                email=inputEmail.getText().toString();
                password=inputPassword.getText().toString();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextName=(EditText) findViewById(R.id.txtUsername);
                String userName=editTextName.getText().toString();

                EditText editTextEmail=(EditText) findViewById(R.id.txtEmail);
                String email=editTextEmail.getText().toString();

                EditText editTextPassword=(EditText) findViewById(R.id.txtPassword);
                String password=editTextPassword.getText().toString();

                Intent intent123= new Intent(Register.this,LoginActivity.class);

                intent123.putExtra("username",userName);
                intent123.putExtra("email",email);
                intent123.putExtra("password",password);

                startActivity(intent123);
            }
        });
    }
}
