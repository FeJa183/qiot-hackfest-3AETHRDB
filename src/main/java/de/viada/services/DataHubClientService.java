package de.viada.services;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://qiot-registration-qiot.apps.cluster-emeaiot-d864.emeaiot-d864.example.opentlc.com", configKey = "datahub-api")
@ApplicationScoped
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public interface DataHubClientService {

    @PUT
    @Path("/v1/register/serial/{serial}/name/{name}/longitude/{longitude}/latitude/{latitude}")
    public int register(@PathParam("serial") String serial,
                    @PathParam("name") String name,
                    @PathParam("longitude") double longitude,
                    @PathParam("latitude") double latitude) throws Exception;
    @DELETE
    @Path("/v1/register/id/{id}")
    public void unregister(@PathParam("id") int id) throws Exception;
}
