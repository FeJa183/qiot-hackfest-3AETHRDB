package de.viada.dtos;

public class SerialRaw {
    private String stationID;
    private String status;

    public SerialRaw() {}

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID.replace("\u0000", "");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
