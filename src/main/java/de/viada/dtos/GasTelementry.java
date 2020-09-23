package de.viada.dtos;

import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.time.Instant;

public class GasTelementry {

    private int stationID;
    private String instant;
    private GasRaw gasData;

    public GasTelementry(GasRaw gasRaw, int stationID) {
        this.gasData = gasRaw;
        this.stationID = stationID;
        this.instant = Instant.now().toString();
    }

    public String toJSONString() {

        return "{" +
                "\"stationId\":" + stationID +
                ",\"instant\": \"" + instant + "\"" +
                ",\"adc\":" + gasData.getAdc() +
                ",\"nh3\":" + gasData.getNh3() +
                ",\"oxidising\":" + gasData.getOxidising() +
                ",\"reducing\":" + gasData.getReducing() +
                '}';
    }

    public double getAdc() {
        return gasData.getAdc();
    }

    public void setAdc(double adc) {
        this.gasData.setAdc(adc);
    }

    public double getNh3() {
        return gasData.getNh3();
    }

    public void setNh3(double nh3) {
        this.gasData.setNh3(nh3);
    }

    public double getOxidising() {
        return gasData.getOxidising();
    }

    public void setOxidising(double oxidising) {
        this.gasData.setOxidising(oxidising);
    }

    public double getReducing() {
        return gasData.getReducing();
    }

    public void setReducing(double reducing) {
        this.gasData.setReducing(reducing);
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getInstant() {
        return instant;
    }

    public void setInstant(String instant) {
        this.instant = instant;
    }

}
