package com.example.ambroziak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PregnancyInfo extends AppCompatActivity {
private int week;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnancy_info);
        Intent intent = getIntent();
        week=intent.getIntExtra("week", 0);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent nextIntent = new Intent(PregnancyInfo.this, FoodAdvice.class);
                    nextIntent.putExtra("week", week);
                    startActivity(nextIntent);
                }
                if (position == 1) {
                    Intent nextIntent = new Intent(PregnancyInfo.this, SportAdvice.class);
                    nextIntent.putExtra("week", week);
                    startActivity(nextIntent);
                }
                if (position == 2) {
                    Intent nextIntent = new Intent(PregnancyInfo.this, BabyInfo.class);
                    nextIntent.putExtra("week", week);
                    startActivity(nextIntent);
                }
            }
        };

        ListView listView = (ListView) findViewById(R.id.Lista_polecen);
        listView.setOnItemClickListener(itemClickListener);
    }
}
