package com.example.ambroziak;


import java.time.LocalDateTime;


public class User {
    private LocalDateTime bornDate;
    private String name;
    private String childName;
    private char childGender;

    public User(LocalDateTime bornDate, String name, String childName, char childGender) {
        this.bornDate = bornDate;
        this.name = name;
        this.childName = childName;
        this.childGender = childGender;

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

    @Override
    public String toString() {
        return "User{" +
                "bornDate=" + bornDate +
                ", name='" + name + '\'' +
                ", childName='" + childName + '\'' +
                ", childGender=" + childGender +
                '}';
    }
}