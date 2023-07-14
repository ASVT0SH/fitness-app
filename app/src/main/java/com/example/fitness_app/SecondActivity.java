package com.example.fitness_app;


import android.content.Intent;
import android.media.tv.AdRequest;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SectionIndexer;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;



public class SecondActivity extends AppCompatActivity {

    int[] newArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);





       Toolbar toolbar=findViewById(R.id.toolBar);
       //setSupportActionBar(toolbar);

       newArray = new int[]{
               R.id.bow_pose,R.id.bridge_pose,R.id.chair_pose,R.id.child_pose,R.id.cobbler_pose,R.id.cow_pose,R.id.playji_pose,
               R.id.pauseji_pose,
       };



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

            Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://iotexpert1.blogspot.com/2021/10/privacy-policy-page-of-plagiarism.html"));
            startActivity(intent);

            return true;
        }
        if(id==R.id.id_term){
            Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://iotexpert1.blogspot.com/2020/10/weight-loss-terms-and-conditions-page.html"));
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
        return true;
    }


    public void Imagebuttonclicked(View view){

        for(int i=0;i< newArray.length;i++){
            if(view.getId()==newArray[i]){
                int value=i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }

    }




}