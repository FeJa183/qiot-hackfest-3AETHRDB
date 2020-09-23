package de.viada.services;

import de.viada.dtos.*;
import io.quarkus.scheduler.Scheduled;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MainService {

    @ConfigProperty(name = "qiot.teamname")
    String teamname;
    @ConfigProperty(name = "qiot.coordinates.longitude")
    double longitude;
    @ConfigProperty(name = "qiot.coordinates.latitude")
    double latitude;
    @Inject
    private CoordinatesService coordinatesService;
    @Inject
    @RestClient
    private SensorClientService sensorClientService;
    @Inject
    @RestClient
    private DataHubClientService dataHubClientService;
    private int teamId;
    @Inject
    private TelemetryService telemetryService;

    @PostConstruct
    public void register() {
        System.out.println(
                "___________                     ____   ____.__            .___       \n" +
                "\\__    ___/___ _____    _____   \\   \\ /   /|__|____     __| _/____   \n" +
                "  |    |_/ __ \\\\__  \\  /     \\   \\   Y   / |  \\__  \\   / __ |\\__  \\  \n" +
                "  |    |\\  ___/ / __ \\|  Y Y  \\   \\     /  |  |/ __ \\_/ /_/ | / __ \\_\n" +
                "  |____| \\___  >____  /__|_|  /    \\___/   |__(____  /\\____ |(____  /\n" +
                "             \\/     \\/      \\/                     \\/      \\/     \\/");
//        this.dataHubClientService.register(System.getProperty('name'))
        CoordinatesBean coordinatesBean = null;

        try {
            coordinatesBean = this.coordinatesService.getCoordinates("Freie-Vogel-Strasse 393 44269 Dortmund");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("No coordinates found, use fallback.");
            coordinatesBean = new CoordinatesBean();
            coordinatesBean.setLatitude(latitude);
            coordinatesBean.setLongitude(longitude);
        }
        System.out.println("Wir sind " + teamname);

        System.out.println(this.sensorClientService.getSerial());

        try {
//            temp.setStationId(temp.getStationId().replace("\u0000", ""));
//            System.out.println(temp.toString());
            this.teamId = this.dataHubClientService.register("000000005937ef4b", teamname, coordinatesBean.getLongitude(), coordinatesBean.getLatitude());
            System.out.println(this.teamId);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    @PreDestroy
    public void unregister() {
        System.out.println("Unregister");
        try {
            this.dataHubClientService.unregister(30);
            System.out.println("Unregister done");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    @Scheduled(every = "5s")
    public void trigger() throws Exception {
        /**
         * Fetch data from Sensor
         */
        try {
            GasRaw gasRaw = this.sensorClientService.getGas();
            System.out.println(gasRaw.toString());

            GasTelementry gasTelementry = new GasTelementry(gasRaw, this.teamId);

            telemetryService.sendGas(gasTelementry.toJSONString());
        } catch (Exception ex){
            ex.printStackTrace();
        }

        try {
            PollutionRaw pollutionRaw = this.sensorClientService.getPollution();
            System.out.println(pollutionRaw.toString());

            PollutionTelemetry pollutionTelemetry = new PollutionTelemetry(pollutionRaw, this.teamId);
            telemetryService.sendPollution(pollutionTelemetry.toJSONString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        //...do magic..

        //PollutionRaw pollutionRaw = this.sensorClientService.pollution();
        //System.out.println(pollutionRaw.toString());
        //...do magic


        /**
         * Sende Daten an Datahub
         */
        //this.dataHubService.xy(gasTelemetry);
        //this.dataHubService.yy(pollutionTelemetry);
    }
}
