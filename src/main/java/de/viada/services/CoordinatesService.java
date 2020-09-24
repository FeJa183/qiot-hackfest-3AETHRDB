package de.viada.services;

import de.viada.dtos.Coordinates;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.net.URL;

/**
 * Service to retreive Coordinates from external Service.
 */
@ApplicationScoped
public class CoordinatesService {

    private static final Logger LOG = Logger.getLogger(CoordinatesService.class);

    /**
     * Retreive Coordinates from external Service by Adress.
     * @param address String
     * @return Coordinates
     * @throws Exception
     */
    public Coordinates getCoordinates(String address)
            throws Exception {
        Coordinates coordinates = null;
        StringBuffer query = null;
        String[] split = null;
        split = address.split(" ");
        query = new StringBuffer();
        query.append("https://nominatim.openstreetmap.org/search?q=");
        if (split.length == 0) {
            return null;
        }
        for (int i = 0; i < split.length; i++) {
            query.append(split[i]);
            if (i < (split.length - 1)) {
                query.append("+");
            }
        }
        query.append("&format=json&addressdetails=1");
        LOG.debug("Query:" + query);
        URL url = new URL(query.toString());
        try (InputStream is = url.openStream();
             JsonReader reader = Json.createReader(is)) {
            JsonArray jsonArray = reader.readArray();
            LOG.debug(jsonArray.toString());
            JsonObject jsonObject = jsonArray.getJsonObject(0);
            LOG.debug(jsonObject.toString());
            coordinates = new Coordinates();
            coordinates.setLongitude(Double
                    .parseDouble(jsonObject.getString("lon")));
            coordinates.setLatitude(Double
                    .parseDouble(jsonObject.getString("lat")));
            LOG.debug(coordinates.toString());
        }
        return coordinates;
    }
}
