package com.example.login1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.os.Bundle;

public class SharedPrefActivity extends AppCompatActivity {

    private EditText name,sex,age,weight,height,mod;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        name = findViewById(R.id.edit1);
        sex= findViewById(R.id.edit2);
        height=findViewById(R.id.edit3);
        weight=findViewById(R.id.edit4);
        age = findViewById(R.id.edit5);
        mod=findViewById(R.id.edit6);
    }


    @Override
    protected void onResume()
    {
        super.onResume();

        SharedPreferences sh
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);

        String s1 = sh.getString("name", "");
        String s2 = sh.getString("sex", "");
        String s3 = sh.getString("height", "");
        String s4 = sh.getString("weight", "");
        String s5 = sh.getString("mod", "");
        int a = sh.getInt("age", 0);


        name.setText(s1);
        sex.setText(s2);
        height.setText(s3);
        weight.setText(s4);
        mod.setText(s5);
        age.setText(String.valueOf(a));
    }


    @Override
    protected void onPause()
    {
        super.onPause();


        SharedPreferences sharedPreferences
                = getSharedPreferences("MySharedPref",
                MODE_PRIVATE);
        SharedPreferences.Editor myEdit
                = sharedPreferences.edit();

        myEdit.putString("name",
                name.getText().toString());

        myEdit.putString("sex",
                sex.getText().toString());

        myEdit.putString("height",
                height.getText().toString());

        myEdit.putString("weight",
                weight.getText().toString());

        myEdit.putString("mod",
                mod.getText().toString());

        myEdit.putInt("age",
                Integer.parseInt(
                        age.getText().toString()));
        myEdit.commit();
    }
}
