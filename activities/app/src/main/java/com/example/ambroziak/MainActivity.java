package com.example.ambroziak;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private User user;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void check_born(View view){

        Intent intent =new Intent(this,BornCalendary.class);
        intent.putExtra("born",user.getDayToBorn());
        startActivity(intent);

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void createUser(View view){
        Intent intent3=new Intent(this,CreateUser.class);

        startActivityForResult(intent3,SECOND_ACTIVITY_REQUEST_CODE);
        user=(User) intent3.getParcelableExtra("user");
    }


}
