package com.example.flashcardsappdraft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    final String TITLE = "Home";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        ImageButton img1 = findViewById(R.id.imageButton2);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, FlashCard1.class);
                startActivity(intent);
            }
        });
        //setContentView(R.layout.home);
        Log.v(TITLE, "On Create!");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "On Start!");
    }


    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TITLE, "On Resume!");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TITLE,  "On Stop");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TITLE, "On pause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TITLE, "On Destroy");
    }
}