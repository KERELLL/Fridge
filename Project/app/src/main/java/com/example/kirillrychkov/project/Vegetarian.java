package com.example.kirillrychkov.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Vegetarian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetarian);
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Vegetarian.this,MainActivity.class);
        startActivity(intent);


    }
}