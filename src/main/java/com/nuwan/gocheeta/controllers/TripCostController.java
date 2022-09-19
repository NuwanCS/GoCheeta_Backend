package com.nuwan.gocheeta.controllers;

import com.nuwan.gocheeta.model.TripCost;
import com.nuwan.gocheeta.services.AbstractService;
import com.nuwan.gocheeta.services.TripCostService;
import jakarta.ws.rs.Path;

/**
 *
 * @author Nuwan
 */
@Path("trip-cost")
public class TripCostController extends AbstractRestController<TripCost>{
    private static final AbstractService service = new TripCostService();

    public TripCostController() {
        super(service, TripCost.class);
    }
}
