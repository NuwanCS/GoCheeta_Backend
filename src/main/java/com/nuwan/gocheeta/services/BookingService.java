package com.nuwan.gocheeta.services;

import com.nuwan.gocheeta.db.AbstractDbUtil;
import com.nuwan.gocheeta.db.BookingDBUtils;
import com.nuwan.gocheeta.model.Booking;

/**
 *
 * @author Nuwan
 */

public class BookingService extends AbstractService<Booking> {

    private static final AbstractDbUtil utils = new BookingDBUtils();

    public BookingService() {
        super(utils);
    }

}
