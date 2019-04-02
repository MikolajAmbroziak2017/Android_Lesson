package com.example.ambroziak;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BornCalendary extends AppCompatActivity {
    private final Long dayLong=86400000L;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_born_calendary);
        Intent intent=getIntent();
        Long  dayToBorn=intent.getLongExtra("born",0);
        TextView tydzien=(TextView) findViewById(R.id.textView5);
        TextView doPorodu=(TextView) findViewById(R.id.textView6);
        CalendarView calendarView=(CalendarView) findViewById(R.id.calendarView);
        calendarView.setMinDate(System.currentTimeMillis());
        tydzien.setText(String.valueOf((280-dayToBorn)/7));
        doPorodu.setText(String.valueOf(dayToBorn));
        calendarView.setDate(System.currentTimeMillis()+dayLong*(dayToBorn));
    }
}
