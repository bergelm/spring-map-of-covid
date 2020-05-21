package com.example.springmapofcovid;

public class Point {

    private double latitude;
    private double longitude;
    private String text;

    public Point() {
    }

    public Point(double latitude, double longitude, String text) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.text = text;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
