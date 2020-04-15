package com.example.login1;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class person {

    private String name;
    private String age;
    private int photo_id;

    public String getName()
    {
        return this.name;
    }
    public String getAge()
    {
        return this.age;
    }
    public int getPhoto_id()
    {
        return this.photo_id;
    }

    public person(String name,String age,int photo_id)
    {
        this.name = name;
        this.age = age;
        this.photo_id = photo_id;
    }
    public person()
    {

    }


}