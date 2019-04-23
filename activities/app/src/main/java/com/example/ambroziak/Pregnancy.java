package com.example.ambroziak;

public class Pregnancy {
    private int IdWeek;
    private String foodAdvice;
    private String sportAdvice;
    private String babyInfo;
    private int imageResourceId;

    public Pregnancy(int idWeek, String foodAdvice, String sportAdvice, String babyInfo, int imageResourceId) {
        IdWeek = idWeek;
        this.foodAdvice = foodAdvice;
        this.sportAdvice = sportAdvice;
        this.babyInfo = babyInfo;
        this.imageResourceId = imageResourceId;
    }

    public Pregnancy() {
    }

    public static Pregnancy[] getPregnancyWeekPerioids() {
        return PREGNANCY_WEEK_PERIOIDS;
    }

    public static final Pregnancy[] PREGNANCY_WEEK_PERIOIDS =
            {
                    new Pregnancy(1, "jedz jagody1", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(2, "jedz jagody2", "rób pompki", "tydzien pozapłodnienie", 1),
                    new Pregnancy(3, "jedz jagody3", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(4, "jedz jagody4", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(5, "jedz jagody5", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(6, "jedz jagody6", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(7, "jedz jagody7", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(8, "jedz jagody8", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(9, "jedz jagody9", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(10, "jedz jagody0", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(11, "jedz jagody11", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(12, "jedz jagody12", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(13,"jedz jagody13", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(14, "jedz jagody14", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(15, "jedz jagody15", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(16, "jedz jagody16", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(17, "jedz jagody17", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(18, "jedz jagody18", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(19, "jedz jagody19", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(20, "jedz jagody20", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(21, "jedz jagody21", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(22, "jedz jagody22", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(23, "jedz jagody23", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(24, "jedz jagody24", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(25, "jedz jagody25", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(26, "jedz jagody26", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(27, "jedz jagody27", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(28, "jedz jagody28", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(29, "jedz jagody29", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(30, "jedz jagody30", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(31, "jedz jagody31", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(32, "jedz jagody32", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(33, "jedz jagody33", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(34, "jedz jagody34", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(35, "jedz jagody35", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(36, "jedz jagody36", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(37, "jedz jagody37", "rób pompki", "zapłodnienie", 1),
                    new Pregnancy(38, "jedz jagody38", "rób pompki", "zapłodnienie", 1)};

    public int getIdWeek() {
        return IdWeek;
    }

    public void setIdWeek(int idWeek) {
        IdWeek = idWeek;
    }

    public String getFoodAdvice() {
        return foodAdvice;
    }

    public void setFoodAdvice(String foodAdvice) {
        this.foodAdvice = foodAdvice;
    }

    public String getSportAdvice() {
        return sportAdvice;
    }

    public void setSportAdvice(String sportAdvice) {
        this.sportAdvice = sportAdvice;
    }

    public String getBabyInfo() {
        return babyInfo;
    }

    public void setBabyInfo(String babyInfo) {
        this.babyInfo = babyInfo;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    @Override
    public String toString() {
        return "Pregnancy{" +
                "IdWeek=" + IdWeek +
                ", foodAdvice='" + foodAdvice + '\'' +
                ", sportAdvice='" + sportAdvice + '\'' +
                ", babyInfo='" + babyInfo + '\'' +
                ", imageResourceId=" + imageResourceId +
                '}';
    }
}
