package com.nuwan.gocheeta.controllers;

import com.nuwan.gocheeta.model.City;
import com.nuwan.gocheeta.services.AbstractService;
import com.nuwan.gocheeta.services.CityService;
import jakarta.ws.rs.Path;

/**
 *
 * @author Nuwan
 */
@Path("city")
public class CityController extends AbstractRestController<City>{
    private static final AbstractService service = new CityService();

    public CityController() {
        super(service, City.class);
    }
}
