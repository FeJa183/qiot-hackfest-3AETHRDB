package de.viada.dtos;

public class CoordinatesBean {
    private double longitude;
    private double latitude;

    public CoordinatesBean() {}

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "CoordinatesBean{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
