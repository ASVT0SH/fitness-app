package com.example.fitness_app;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;
    Button logout;
    LinearLayout l;
    FirebaseUser user;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();


        user = auth.getCurrentUser();
        if(user==null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
           // finish();
        }
        else{
                return;
        }

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
               // finish();
            }
        });


       Toolbar toolbar = findViewById(R.id.toolBar);
       setSupportActionBar(toolbar);


       getSupportActionBar().setTitle("Fitness App");


        button1=findViewById(R.id.startyoga1);
        button2=findViewById(R.id.startyoga2);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               Intent intent =new Intent(MainActivity.this,SecondActivity.class);
               startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent =new Intent(MainActivity.this,SecondActivity2.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.id_privacy){

            Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/10arun/Fitness-App"));
            startActivity(intent);

            return true;
        }
        if(id==R.id.id_term){
            Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/10arun/Fitness-App"));
            startActivity(intent);

            return true;
        }
        if(id==R.id.rate){

            try{
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?=" + getPackageName())));
            }catch(Exception ex){
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
            }

            return true;
        }
        if(id==R.id.more){

            Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=homeworkout.homeworkouts.noequipment"));
            startActivity(intent);
            return true;
        }
        if(id==R.id.share){

            Intent myIntent=new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String sharebody="This app is  one among the top rated app to maintain fitness \n , which is completely free and \n can be downloaded from playstore\n" +"https://play.google.com/store/apps/details?id=com.example.yogaapp&hl=en";
            String sharehub="Fitness App";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,sharehub);
            myIntent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(myIntent,"share using"));

            return true;
        }
        if(id==R.id.logout){
            FirebaseUser currentUser = auth.getCurrentUser();
            if(currentUser != null){
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                FirebaseAuth.getInstance().signOut();
                finish();
            }


        }
        return true;
    }

    public void setSupportActionBar(Toolbar toolbar) {
    }


    public void beforeage18(View view) {
        Intent intent=new Intent(MainActivity.this
        ,SecondActivity.class);
        startActivity(intent);
    }

    public void afterage18(View view) {
        Intent intent=new Intent(MainActivity.this
                ,SecondActivity2.class);
        startActivity(intent);
    }

    public void food(View view) {
        Intent intent=new Intent(MainActivity.this
                ,FoodActivity.class);
        startActivity(intent);
    }
}