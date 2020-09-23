package de.viada.services;

import de.viada.dtos.CoordinatesBean;
import de.viada.dtos.GasRaw;
import de.viada.dtos.PollutionRaw;
import io.quarkus.scheduler.Scheduled;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MainService {

    @Inject
    private CoordinatesService coordinatesService;

//    @Inject
//    private SensorClientResource sensorClientResource;

    @Inject
    @RestClient
    private SensorClientService sensorClientService;

    @Inject
    private DataHubService dataHubService;


    private CoordinatesBean coordinatesBean;


    @Scheduled(every = "5s")
    public void trigger() throws Exception {
        System.out.println("Tigger fired.");



        /**
         * Fetch data from Sensor
         */
        GasRaw gasRaw = this.sensorClientService.gas();
        System.out.println(gasRaw.toString());
        //...do magic

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
