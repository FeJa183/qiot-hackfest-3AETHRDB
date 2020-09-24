package de.viada.services;

import de.viada.dtos.GasRaw;
import de.viada.dtos.PollutionRaw;
import de.viada.dtos.SerialRaw;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Service to retreive Data from Hardware/Pi
 */
@RegisterRestClient(baseUri = "http://qiot-sensor-service:5000")
public interface SensorClientService {

    /**
     * Retreive raw Gas Data from Sensor
     * @return GasRaw
     */
    @GET
    @Path("/gas")
    @Consumes(MediaType.APPLICATION_JSON)
    GasRaw getGas();

    /**
     * Retreive raw Pollution from Sensor
     * @return PollutionRaw
     */
    @GET
    @Path("/pollution")
    @Consumes(MediaType.APPLICATION_JSON)
    PollutionRaw getPollution();

    /**
     * Retreive Serial-Id from Sensor
     * @return SerialRaw
     */
    @GET
    @Path("/serial")
    @Consumes(MediaType.APPLICATION_JSON)
    SerialRaw getSerial();
}
