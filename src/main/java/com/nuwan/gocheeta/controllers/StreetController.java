package com.nuwan.gocheeta.controllers;

import com.nuwan.gocheeta.model.Street;
import com.nuwan.gocheeta.services.AbstractService;
import com.nuwan.gocheeta.services.StreetService;
import jakarta.ws.rs.Path;

/**
 *
 * @author Nuwan
 */
@Path("street")
public class StreetController extends AbstractRestController<Street>{
    private static final AbstractService service = new StreetService();

    public StreetController() {
        super(service, Street.class);
    }
}
