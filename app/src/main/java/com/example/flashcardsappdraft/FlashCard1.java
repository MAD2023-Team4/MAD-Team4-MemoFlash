package com.example.flashcardsappdraft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FlashCard1 extends AppCompatActivity {
    final String TITLE = "FlashCard1";

    int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashcard1);

        String qt1 = getString(R.string.q1);
        String qt2 = getString(R.string.q2);
        String qt3 = getString(R.string.q3);
        String qt4 = getString(R.string.q4);

        ArrayList<String> qList = new ArrayList<>();
        qList.add(qt1);
        qList.add(qt2);
        qList.add(qt3);
        qList.add(qt4);

        String at1 = getString(R.string.a1);
        String at2 = getString(R.string.a2);
        String at3 = getString(R.string.a3);
        String at4 = getString(R.string.a4);

        ArrayList<String> aList = new ArrayList<>();
        aList.add(at1);
        aList.add(at2);
        aList.add(at3);
        aList.add(at4);

        TextView q1 = findViewById(R.id.textView4);
        TextView a1 = findViewById(R.id.textView5);

        Button b1 = findViewById(R.id.button7);
        Button b2 = findViewById(R.id.button3);
        Button b3 = findViewById(R.id.button4);

        a1.setVisibility(View.GONE);

        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == q1) {
                    a1.setVisibility(View.VISIBLE);
                    q1.setVisibility(View.GONE);
                }

            }
        });

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == a1) {
                    q1.setVisibility(View.VISIBLE);
                    a1.setVisibility(View.GONE);
                }

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlashCard1.this, Home.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TITLE, String.valueOf(currentIndex));
                currentIndex--;
                if (currentIndex <= 0) {
                    currentIndex = qList.size();
                }
                q1.setText(qList.get(currentIndex));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex >= qList.size()) {
                    currentIndex = 0;
                }
                q1.setText(qList.get(currentIndex));
            }
        });

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