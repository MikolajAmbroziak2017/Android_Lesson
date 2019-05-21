package com.example.ambroziak;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.Toast;

public class UpdateUser extends AsyncTask<String, Void, Boolean> {
    DatabaseHelper myDb;
    Context context;
    public UpdateUser(DatabaseHelper myDb, Context context){
        this.myDb=myDb;
        this.context=context;
    }
    @Override
    protected Boolean doInBackground(String ... strings) {
        String name=strings[0];
        String childName=strings[1];
        String gender=strings[2];
        String date=strings[3];
        SQLiteDatabase db=myDb.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("NAME",name);
        values.put("CHILDNAME",childName);
        values.put("GENDER",gender);
        values.put("DATE",date);
        db.insert("USER",null,values);
        return true;
    }
    protected void onPostExecute(Boolean result) {
        if(!result)
            Toast.makeText(context,"USER DIDNT ADD",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context,"Added User",Toast.LENGTH_LONG).show();

    }

}
