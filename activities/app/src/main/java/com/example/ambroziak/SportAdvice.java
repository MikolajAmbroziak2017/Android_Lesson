package com.example.ambroziak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SportAdvice extends AppCompatActivity {
private int week;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_advice);
        Intent intent =getIntent();
        week = intent.getIntExtra("week",0);
        Pregnancy[] weekList=Pregnancy.PREGNANCY_WEEK_PERIOIDS;
        Pregnancy pregnancy=weekList[week-1];
        TextView textView=(TextView)findViewById(R.id.sport_advice);
        textView.setText(pregnancy.getSportAdvice());
        }
}
