package com.nuwan.gocheeta.controllers;

import com.nuwan.gocheeta.model.Vehicle;
import com.nuwan.gocheeta.services.AbstractService;
import com.nuwan.gocheeta.services.VehicleService;
import jakarta.ws.rs.Path;

/**
 *
 * @author Nuwan
 */
@Path("vehicle")
public class VehicleController extends AbstractRestController<Vehicle>{
    private static final AbstractService service = new VehicleService();

    public VehicleController() {
        super(service, Vehicle.class);
    }
}
