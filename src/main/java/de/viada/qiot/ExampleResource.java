package de.viada.qiot;

import de.viada.services.CoordinatesService;
import de.viada.services.DataHubClientService;
import de.viada.services.SensorClientService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    private static final Logger LOG = Logger.getLogger(ExampleResource.class);

    CoordinatesService coordinatesService = new CoordinatesService();

    @Inject
    @RestClient
    DataHubClientService dataHubClientService;

    @Inject
    @RestClient
    SensorClientService sensorClientService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws Exception {
        LOG.info("Coordinates: " + coordinatesService.getCoordinates("Freie-Vogel-Straße 393 44269 Dortmund"));
        LOG.info("Gas: " + sensorClientService.gas());
        LOG.info("Pollution: " + sensorClientService.pollution());
        return "hello";
    }
}
