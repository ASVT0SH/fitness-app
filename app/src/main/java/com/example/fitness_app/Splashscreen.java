 package com.example.fitness_app;

import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

 public class Splashscreen extends AppCompatActivity {

    ImageView imageView;
    TextView  textView;
    Animation up,down;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().setTitle("Fitness App");
        ImageView imageView=findViewById(R.id.appsplash);
        up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        imageView.setAnimation(up);


        TextView textView =findViewById(R.id.appname);
        down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        imageView.setAnimation(down);


        new Handler().postDelayed(new Runnable(){
            public void run(){
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }

        },3500);



    }
}