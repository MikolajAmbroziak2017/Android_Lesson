package com.example.ambroziak;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;

public class CreateUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
    }

@RequiresApi(api = Build.VERSION_CODES.O)
public void onClick(View view){
    Switch data= (Switch) findViewById(R.id.data);
    Spinner day=(Spinner) findViewById(R.id.day);
    Spinner month=(Spinner) findViewById(R.id.month);
    Spinner year=(Spinner) findViewById(R.id.year);
    TextView name= (TextView) findViewById(R.id.name);
    TextView childName = (TextView) findViewById(R.id.childName);
    RadioButton male=(RadioButton) findViewById(R.id.male);


    if(data.isChecked()) {

        String sYear=String.valueOf(year.getSelectedItem());
        String sMonth=String.valueOf(month.getSelectedItem());
        String sDay=String.valueOf(day.getSelectedItem());
        LocalDateTime birt=LocalDateTime.of(Integer.parseInt(sYear),Integer.parseInt(sMonth),Integer.parseInt(sDay),0,0);
         User user=new User(birt,String.valueOf(name.getText()),String.valueOf(childName.getText()),(male.isChecked())?'m':'k');
        Toast.makeText(getApplicationContext(),"Add User",Toast.LENGTH_LONG).show();
        Intent intent = new Intent();
        intent.putExtra("user", user);
        setResult(RESULT_OK, intent);
        finish();

        //finish();
    }
}
}
