package com.nuwan.gocheeta.controllers;

import com.nuwan.gocheeta.model.Booking;
import com.nuwan.gocheeta.services.AbstractService;
import com.nuwan.gocheeta.services.BookingService;
import jakarta.ws.rs.Path;

/**
 *
 * @author Nuwan
 */
@Path("booking")
public class BookingController extends AbstractRestController<Booking>{
    private static final AbstractService service = new BookingService();

    public BookingController() {
        super(service, Booking.class);
    }
}
