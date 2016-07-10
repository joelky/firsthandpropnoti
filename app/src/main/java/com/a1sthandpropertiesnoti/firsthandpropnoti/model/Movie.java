package com.a1sthandpropertiesnoti.firsthandpropnoti.model;

        import java.util.ArrayList;

public class Movie {
    private String propertyNameChi, thumbnailUrl;
    private int year;
    private double propertyNameEng;
    private ArrayList<String> genre;

    public Movie() {
    }

    public Movie(String name, String thumbnailUrl, int year, double propertyNameEng,
                 ArrayList<String> genre) {
        this.propertyNameChi = name;
        this.thumbnailUrl = thumbnailUrl;
        this.year = year;
        this.propertyNameEng = propertyNameEng;
        this.genre = genre;
    }

    public String getPropertyNameChi() {
        return propertyNameChi;
    }

    public void setPropertyNameChi(String name) {
        this.propertyNameChi = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPropertyNameEng() {
        return propertyNameEng;
    }

    public void setPropertyNameEng(double propertyNameEng) {
        this.propertyNameEng = propertyNameEng;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

}