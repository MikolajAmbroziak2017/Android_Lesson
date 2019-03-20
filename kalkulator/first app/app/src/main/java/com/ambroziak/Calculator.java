package com.ambroziak;

public class Calculator {
    private Float licznik;
    private Float mianownik;

    public Calculator(String licznik, String mianownik) {
        this.licznik = Float.parseFloat(licznik);
        this.mianownik = Float.parseFloat(mianownik);
    }
public String takeAction(String action){
        if(action.contains("+"))
        return addition();
        if(action.contains("-"))
            return subtracktion();
        if(action.contains("*"))
            return multiply();
        if (action.contains("/"))
            return division();
        return "0";
}
    public String multiply(){

        return String.valueOf(licznik*mianownik);
    }
    public String addition(){

        return String.valueOf(licznik+mianownik);
    }
    public String subtracktion(){

        return String.valueOf(mianownik-licznik);
    }
    public String division(){

        return String.valueOf(mianownik/licznik);
    }

    public Float getLicznik() {
        return licznik;
    }

    public void setLicznik(Float licznik) {
        this.licznik = licznik;
    }

    public Float getMianownik() {
        return mianownik;
    }

    public void setMianownik(Float mianownik) {
        this.mianownik = mianownik;
    }
}
