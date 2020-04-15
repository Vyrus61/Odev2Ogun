package com.example.login1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;

import com.example.login1.R;
import java.util.ArrayList;
import java.util.List;



import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class RecylerViewActivity extends AppCompatActivity {
    private RecyclerView recycler_view;
    private List<person> person_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view);


        recycler_view = (RecyclerView)findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        recycler_view.setLayoutManager(layoutManager);

        person_list = new ArrayList<person>();

        person_list.add(new person("Alper Beyler", "23 yaş", R.drawable.loginlogo));
        person_list.add(new person("Taha Kırca", "25 yaş", R.drawable.loginlogo));



        ProductAdapter adapter_items = new ProductAdapter(person_list, new ProductAdapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Log.d("position", "Tıklanan Pozisyon:" + position);
                person person = person_list.get(position);
                Toast.makeText(getApplicationContext(),"pozisyon:"+" "+position+" "+"Ad:"+person.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        recycler_view.setHasFixedSize(true);

        recycler_view.setAdapter(adapter_items);

        recycler_view.setItemAnimator(new DefaultItemAnimator());


    }

}
