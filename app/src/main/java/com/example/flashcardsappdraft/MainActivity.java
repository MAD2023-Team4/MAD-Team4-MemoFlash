package com.example.flashcardsappdraft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final String TITLE = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        User myUser = new User();
        myUser.getName();

        Button myButton = findViewById(R.id.button2);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, "Login button is pressed");
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);

            }
        });

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