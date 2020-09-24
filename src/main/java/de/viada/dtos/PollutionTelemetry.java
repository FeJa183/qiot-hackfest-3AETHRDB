package de.viada.dtos;

import java.time.Instant;

public class PollutionTelemetry {
    private int stationID;
    private String instant;
    private PollutionRaw pollutionData;

    public PollutionTelemetry() {
    }

    public PollutionTelemetry(PollutionRaw pollutionRaw, int teamId) {
        this.pollutionData = pollutionRaw;
        this.stationID = teamId;

        this.instant = Instant.now().toString();
    }

    public int getPm1_0() {
        return pollutionData.getPm1_0();
    }

    public void setPm1_0(int pm1_0) {
        this.pollutionData.setPm1_0(pm1_0);
    }

    public int getPm2_5() {
        return pollutionData.getPm2_5();
    }

    public void setPm2_5(int pm2_5) {
        this.pollutionData.setPm2_5(pm2_5);
    }

    public int getPm10() {
        return pollutionData.getPm10();
    }

    public void setPm10(int pm10) {
        this.pollutionData.setPm10(pm10);
    }

    public int getPm1_0_atm() {
        return pollutionData.getPm1_0_atm();
    }

    public void setPm1_0_atm(int pm1_0_atm) {
        this.pollutionData.setPm1_0_atm(pm1_0_atm);
    }

    public int getPm2_5_atm() {
        return pollutionData.getPm2_5_atm();
    }

    public void setPm2_5_atm(int pm2_5_atm) {
        this.pollutionData.setPm2_5_atm(pm2_5_atm);
    }

    public int getPm10_atm() {
        return pollutionData.getPm10_atm();
    }

    public void setPm10_atm(int pm10_atm) {
        this.pollutionData.setPm10_atm(pm10_atm);
    }

    public int getGt0_3() {
        return pollutionData.getGt0_3();
    }

    public void setGt0_3(int gt0_3) {
        this.pollutionData.setGt0_3(gt0_3);
    }

    public int getGt0_5() {
        return pollutionData.getGt0_5();
    }

    public void setGt0_5(int gt0_5) {
        this.pollutionData.setGt0_5(gt0_5);
    }

    public int getGt1_0() {
        return pollutionData.getGt1_0();
    }

    public void setGt1_0(int gt1_0) {
        this.pollutionData.setGt1_0(gt1_0);
    }

    public int getGt2_5() {
        return pollutionData.getGt2_5();
    }

    public void setGt2_5(int gt2_5) {
        this.pollutionData.setGt2_5(gt2_5);
    }

    public int getGt5_0() {
        return pollutionData.getGt5_0();
    }

    public void setGt5_0(int gt5_0) {
        this.pollutionData.setGt5_0(gt5_0);
    }

    public int getGt10um() {
        return pollutionData.getGt10um();
    }

    public void setGt10um(int gt10um) {
        this.pollutionData.setGt10um(gt10um);
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

    public String toJSONString() {
        return "{" +
                "\"stationId\":" + this.stationID +
                ",\"instant\": \"" + instant +"\"" +
                ",\"pm1_0\":" + pollutionData.getPm1_0() +
                ",\"pm2_5\":" + pollutionData.getGt2_5() +
                ",\"pm10\":" + pollutionData.getPm10() +
                ",\"pm1_0_atm\":" + pollutionData.getPm1_0_atm() +
                ",\"pm2_5_atm\":" + pollutionData.getPm2_5_atm() +
                ",\"pm10_atm\":" + pollutionData.getPm10_atm() +
                ",\"gt0_3um\":" + pollutionData.getGt0_3() +
                ",\"gt0_5um\":" + pollutionData.getGt0_5() +
                ",\"gt1_0um\":" + pollutionData.getGt1_0() +
                ",\"gt2_5um\":" + pollutionData.getGt2_5() +
                ",\"gt5_0um\":" + pollutionData.getGt5_0() +
                ",\"gt10um\":" + pollutionData.getGt10um() +
                '}';
    }




}
