package com.nuwan.gocheeta.services;

import com.nuwan.gocheeta.db.AbstractDbUtil;
import com.nuwan.gocheeta.db.VehicleDBUtils;
import com.nuwan.gocheeta.model.Vehicle;

/**
 *
 * @author Nuwan
 */

public class VehicleService extends AbstractService<Vehicle> {

    private static final AbstractDbUtil utils = new VehicleDBUtils();

    public VehicleService() {
        super(utils);
    }

}
