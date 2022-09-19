package com.nuwan.gocheeta.controllers;

import com.nuwan.gocheeta.model.VehicleCategory;
import com.nuwan.gocheeta.services.AbstractService;
import com.nuwan.gocheeta.services.VehicleCategoryService;
import jakarta.ws.rs.Path;

/**
 *
 * @author Nuwan
 */
@Path("vehicle-cat")
public class VehicleCategoryController extends AbstractRestController<VehicleCategory>{
    private static final AbstractService service = new VehicleCategoryService();

    public VehicleCategoryController() {
        super(service, VehicleCategory.class);
    }
}
