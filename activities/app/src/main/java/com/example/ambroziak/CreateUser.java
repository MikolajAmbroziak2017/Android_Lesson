package com.example.ambroziak;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;

import android.widget.Toast;

import java.time.LocalDateTime;

public class CreateUser extends AppCompatActivity {
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        myDb=new DatabaseHelper(this);
    }

@RequiresApi(api = Build.VERSION_CODES.O)
public void onClick(View view){


    Switch data= (Switch) findViewById(R.id.data);
    Spinner day=(Spinner) findViewById(R.id.day);
    Spinner month=(Spinner) findViewById(R.id.month);
    Spinner year=(Spinner) findViewById(R.id.year);
    EditText name= (EditText) findViewById(R.id.name);
    EditText childName = (EditText) findViewById(R.id.childName);
    RadioButton male=(RadioButton) findViewById(R.id.male);


    if(data.isChecked()) {

        String sYear=String.valueOf(year.getSelectedItem());
        String sMonth=String.valueOf(month.getSelectedItem());
        String sDay=String.valueOf(day.getSelectedItem());
        LocalDateTime birt=LocalDateTime.of(Integer.parseInt(sYear),Integer.parseInt(sMonth),Integer.parseInt(sDay),0,0);
       System.out.println(sYear+sMonth+sDay+birt);
        Toast.makeText(getApplicationContext(),"Add User",Toast.LENGTH_LONG).show();
        String gender;
        if (male.isChecked())
            gender="k";
        else gender="m";
        addToDb(name.getText().toString(),childName.getText().toString(),gender,birt.toString());
        finish();
    }
}

public void addToDb(String name,String childName,String gender,String date){
    SQLiteDatabase db=myDb.getWritableDatabase();
    ContentValues values=new ContentValues();
    values.put("NAME",name);
    values.put("CHILDNAME",childName);
    values.put("GENDER",gender);
    values.put("DATE",date);
    db.insert("USER",null,values);
}

}
