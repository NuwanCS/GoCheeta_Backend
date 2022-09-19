package com.nuwan.gocheeta.services;

import com.nuwan.gocheeta.db.AbstractDbUtil;
import com.nuwan.gocheeta.db.TripCostDBUtils;
import com.nuwan.gocheeta.model.TripCost;

/**
 *
 * @author Nuwan
 */

public class TripCostService extends AbstractService<TripCost> {

    private static final AbstractDbUtil utils = new TripCostDBUtils();

    public TripCostService() {
        super(utils);
    }

}
