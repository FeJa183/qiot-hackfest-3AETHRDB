package de.viada.services;

import de.viada.dtos.GasRaw;
import de.viada.dtos.PollutionRaw;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("http://192.168.45.92:5000")
@RegisterRestClient()
public interface SensorClientService {
    @GET
    @Path("/gas")
    @Consumes(MediaType.APPLICATION_JSON)
    GasRaw gas();

    @GET
    @Path("/pollution")
    @Consumes(MediaType.APPLICATION_JSON)
    PollutionRaw pollution();
}
