package com.example.login1;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;


public class SensorActivity extends AppCompatActivity {
    SensorManager smm;
    ListView listView;
    SensorManager sensorManager;
    List<Sensor> listsensor;
    List<String> liststring;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        listView = (ListView) findViewById(R.id.listview1);

        liststring = new ArrayList<String>();

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        listsensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (int i = 0; i < listsensor.size(); i++) {

            liststring.add(listsensor.get(i).getName());
        }

        adapter = new ArrayAdapter<String>(SensorActivity.this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1, liststring
        );

        listView.setAdapter(adapter);

    }
}