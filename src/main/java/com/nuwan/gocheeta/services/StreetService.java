package com.nuwan.gocheeta.services;

import com.nuwan.gocheeta.db.AbstractDbUtil;
import com.nuwan.gocheeta.db.StreetDBUtils;
import com.nuwan.gocheeta.model.Street;

/**
 *
 * @author Nuwan
 */

public class StreetService extends AbstractService<Street> {

    private static final AbstractDbUtil utils = new StreetDBUtils();

    public StreetService() {
        super(utils);
    }

}
