package com.example.fitness_app;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodActivity extends AppCompatActivity {

    ListView listview;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        String []tstory=getResources().getStringArray(R.array.title_story);
        final String [] dstory=getResources().getStringArray(R.array.details_story);


        listview=findViewById(R.id.list);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.row,R.id.rowtxt,tstory);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t =dstory[position];
                Intent intent=new Intent(FoodActivity.this, com.example.fitness_app.FoodActivityDetails.class);
                intent.putExtra("story",t);
                startActivity(intent);
            }
        });
    }


}