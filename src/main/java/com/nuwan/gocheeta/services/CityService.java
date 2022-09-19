package com.nuwan.gocheeta.services;

import com.nuwan.gocheeta.db.AbstractDbUtil;
import com.nuwan.gocheeta.db.CityDBUtils;
import com.nuwan.gocheeta.model.City;

/**
 *
 * @author Nuwan
 */

public class CityService extends AbstractService<City> {

    private static final AbstractDbUtil utils = new CityDBUtils();

    public CityService() {
        super(utils);
    }

}
