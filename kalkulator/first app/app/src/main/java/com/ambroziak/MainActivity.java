package com.ambroziak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void count(View view){
        TextView result =(TextView) findViewById(R.id.wynik);
 //       result.setText("testy");
        Spinner licznik = (Spinner)findViewById(R.id.licznik);
        Spinner dzielnik = (Spinner)findViewById(R.id.dzielnik);
        Spinner dzialanie = (Spinner)findViewById(R.id.dzialanie);
        Calculator calculator=new Calculator(String.valueOf(licznik.getSelectedItem()),String.valueOf(dzielnik.getSelectedItem()));
        result.setText(calculator.takeAction(String.valueOf(dzialanie.getSelectedItem())));
    }
}
