package com.example.login1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {



    String nameOrEmailL;
    String passwordL;
    int i=2;

    EditText inputName;
    EditText inputEmail;
    EditText inputPassword;

    Button btnLogin;


    private Toolbar actionbarLogin;
    public void init(){
        actionbarLogin=(Toolbar) findViewById(R.id.actionbarLogin);
        setSupportActionBar(actionbarLogin);
        getSupportActionBar().setTitle("Giris Yap");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        inputName=(EditText) findViewById(R.id.txtUsername);
        inputPassword=(EditText) findViewById(R.id.txtPassword);

        btnLogin=(Button) findViewById(R.id.btnLogin);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent=getIntent();
        final String userName=intent.getStringExtra("username");
        final String email=intent.getStringExtra("email");
        final String password=intent.getStringExtra("password");


        init();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameOrEmailL = inputName.getText().toString();
                passwordL = inputPassword.getText().toString();
                Toast.makeText(getApplicationContext(), i+"tane giriş hakkın kaldı", Toast.LENGTH_SHORT).show();

                if (i>=0) {
                    if (nameOrEmailL.equals(userName) || nameOrEmailL.equals(email)) {
                        if (passwordL.equals(password)) {
                            Toast.makeText(getApplicationContext(), "Giriş yapıldı", Toast.LENGTH_SHORT).show();
                            Intent intentMain= new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intentMain);



                        } else {
                            Toast.makeText(getApplicationContext(), "Şifre hatalı", Toast.LENGTH_SHORT).show();

                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "kullanıcı adı veya email hatalı", Toast.LENGTH_SHORT).show();

                    }
                    i--;
                }
                if(i==0){
                    finishAffinity();
                }

            }
        });

    }
}
