package com.example.ambroziak;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class MainActivity extends AppCompatActivity {
   public DatabaseHelper myDb;
    public User user;
    private OdometerService odometer;
    private boolean bound = false;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder binder) {
            OdometerService.OdometerBinder odometerBinder =
                    (OdometerService.OdometerBinder) binder;
            odometer = odometerBinder.getOdometer();
            bound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            bound = false;
        }
    };


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);
        watchMileage();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void check_born(View view) {

        Intent intent = new Intent(this, BornCalendary.class);
        intent.putExtra("born",calcDayToBorn());
        startActivity(intent);

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void goToBabyInformation(View view){
        Intent intent= new Intent(this,PregnancyInfo.class);
        int week= (int) ((280-calcDayToBorn())/7);
        intent.putExtra("week",week);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public long calcDayToBorn()
    {
        LocalDateTime born=user.getBornDate();
        LocalDateTime cur= LocalDateTime.now();
        long between = DAYS.between(cur, born);
        return between+1;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void createUser(View view) {
        Intent intent3 = new Intent(this, CreateUser.class);
        startActivity(intent3);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void readUserFromDb(View view){
        SQLiteDatabase db=myDb.getWritableDatabase();
        int choosen;
        Spinner spinner=(Spinner)findViewById(R.id.spinner) ;
        choosen=Integer.parseInt(String.valueOf(spinner.getSelectedItem()));
        Cursor c = db.rawQuery("SELECT * FROM USER WHERE ID = '"+choosen+"'", null);
        c.moveToNext();
        String name=c.getString(c.getColumnIndex("NAME"));
        String childName=c.getString(c.getColumnIndex("CHILDNAME"));
        String gender=c.getString(c.getColumnIndex("GENDER"));
        String Date=c.getString(c.getColumnIndex("DATE"));
        TextView textView=(TextView)findViewById(R.id.textView10);

        user=new User(LocalDateTime.parse(Date),name,childName,gender.charAt(0));
        textView.setText(user.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, OdometerService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (bound) {
            unbindService(connection);
            bound = false;
        }
    }

    private void watchMileage() {
        final TextView distanceView = (TextView)findViewById(R.id.distance);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                double distance = 0.0;
                if (odometer != null) {
                    distance = odometer.getDistance();
                }
                String distanceStr = String.format("%1$,.2f kilometra", distance);
                distanceView.setText(distanceStr);
                handler.postDelayed(this, 1000);
            }
        });
    }
}
