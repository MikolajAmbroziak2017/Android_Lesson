package com.example.ambroziak;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.CalendarView;

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
        int  dayToBorn=intent.getIntExtra("born",7);
        CalendarView calendarView=(CalendarView) findViewById(R.id.calendarView);
        calendarView.setMinDate(System.currentTimeMillis());
        calendarView.setDate(System.currentTimeMillis()+dayLong*dayToBorn);
    }
}
