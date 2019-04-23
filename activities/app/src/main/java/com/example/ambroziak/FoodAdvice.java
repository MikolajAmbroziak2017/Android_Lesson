package com.example.ambroziak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FoodAdvice extends AppCompatActivity {
    private int week;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_advice);
        Intent intent =getIntent();
        week=intent.getIntExtra("week",0);
        Pregnancy[] weekList=Pregnancy.PREGNANCY_WEEK_PERIOIDS;
        Pregnancy pregnancies=weekList[week-1];
        TextView textView=(TextView)findViewById(R.id.food_advice);
        textView.setText(pregnancies.getFoodAdvice());
    }
}
