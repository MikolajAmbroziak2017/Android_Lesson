package com.example.ambroziak;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class User implements Parcelable {
    private LocalDateTime bornDate;
    private String name;
    private String childName;
    private char childGender;
    private long dayToBorn;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public User(LocalDateTime bornDate, String name, String childName, char childGender) {
        this.bornDate = bornDate;
        this.name = name;
        this.childName = childName;
        this.childGender = childGender;
        this.dayToBorn = dayToBorn();
    }

    public LocalDateTime getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDateTime bornDate) {
        this.bornDate = bornDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public char getChildGender() {
        return childGender;
    }

    public void setChildGender(char childGender) {
        this.childGender = childGender;
    }

    public long getDayToBorn() {
        return dayToBorn;
    }

    public void setDayToBorn(long dayToBorn) {
        this.dayToBorn = dayToBorn;
    }

    public static Creator<User> getCREATOR() {
        return CREATOR;
    }

    protected User(Parcel in) {
        name = in.readString();
        childName = in.readString();
        childGender = (char) in.readInt();
        dayToBorn = in.readLong();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.O)
    public long dayToBorn(){
        LocalDate cur= LocalDate.now();
        return DAYS.between(bornDate,cur);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(childName);
        dest.writeInt((int) childGender);
        dest.writeLong(dayToBorn);
    }
}