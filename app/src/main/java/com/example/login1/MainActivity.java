package com.example.login1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private Sensor lightSensor;
    private SensorEventListener lightEventListener;
    private View root;
    private float maxValue;
    private Button btnWelcomeLogin, getBtnWelcomeRegister,btnSensors,btnNotepad,btnShared,btnEmailSend,btnRecylerView;

    public void init(){

        btnWelcomeLogin=(Button) findViewById(R.id.btnWelcomeLogin);
        getBtnWelcomeRegister=(Button) findViewById(R.id.btnWelcomeRegister);
        btnSensors=(Button)findViewById(R.id.btnSensors);
        btnNotepad=(Button)findViewById(R.id.btnNotepad);
        btnShared=(Button) findViewById(R.id.btnShared);
        btnEmailSend=(Button) findViewById(R.id.btnEmailSend);
        btnRecylerView=(Button) findViewById(R.id.btnRecylerView);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        root = findViewById(R.id.root);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (lightSensor == null) {
            Toast.makeText(this, "The device has no light sensor !", Toast.LENGTH_SHORT).show();
            finish();
        }

        // max value for light sensor
        maxValue = lightSensor.getMaximumRange();

        lightEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float value = sensorEvent.values[0];



                int newValue = (int) (255f * value / maxValue);
                root.setBackgroundColor(Color.rgb(newValue, newValue, newValue));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };



       init();

        btnSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSensor= new Intent(MainActivity.this,SensorActivity.class);
                startActivity(intentSensor);
            }
        });

        btnShared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentShared= new Intent(MainActivity.this,SharedPrefActivity.class);
                startActivity(intentShared);
            }
        });

        btnWelcomeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin= new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intentLogin);
            }
        });

        getBtnWelcomeRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister =new Intent(MainActivity.this,Register.class);
                startActivity(intentRegister);
            }
        });
        btnNotepad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNotepad =new Intent(MainActivity.this,NotepadActivity.class);
                startActivity(intentNotepad);
            }
        });
        btnEmailSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEmail= new Intent(MainActivity.this,EmailSendActivity.class);
                startActivity(intentEmail);
            }
        });
        btnRecylerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRecyler= new Intent(MainActivity.this,RecylerViewActivity.class);
                startActivity(intentRecyler);
            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(lightEventListener, lightSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(lightEventListener);
    }
}
