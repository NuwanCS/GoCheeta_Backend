package com.nuwan.gocheeta.services;

import com.nuwan.gocheeta.db.AbstractDbUtil;
import com.nuwan.gocheeta.db.VehicleCategoryDBUtils;
import com.nuwan.gocheeta.model.VehicleCategory;

/**
 *
 * @author Nuwan
 */

public class VehicleCategoryService extends AbstractService<VehicleCategory> {

    private static final AbstractDbUtil utils = new VehicleCategoryDBUtils();

    public VehicleCategoryService() {
        super(utils);
    }

}
