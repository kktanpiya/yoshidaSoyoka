package com.example.msdhainizam.loginschoolapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import mehdi.sakout.fancybuttons.FancyButton;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageview = (ImageView) findViewById(R.id.imageView);
        FancyButton loginButton = (FancyButton) findViewById(R.id.btn_login);
        TextView textView = (TextView)findViewById(R.id.register);
        //Fabric.with(this, new Crashlytics());


        Glide.with(this).load(R.drawable.yui_small2).into(imageview);


    }
    public void click_login(View view){

        //Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MySchool_main.class);
        startActivity(intent);


    }
    public void click_register(View view){
        Intent intent = new Intent(this, Register_schoolApp.class);
        startActivity(intent);
    }

}