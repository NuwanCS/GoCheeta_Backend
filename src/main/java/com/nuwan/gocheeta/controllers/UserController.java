package com.nuwan.gocheeta.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nuwan.gocheeta.model.City;
import com.nuwan.gocheeta.model.Login;
import com.nuwan.gocheeta.model.User;
import com.nuwan.gocheeta.services.AbstractService;
import com.nuwan.gocheeta.services.CityService;
import com.nuwan.gocheeta.services.UserService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nuwan
 */
@Path("user")
public class UserController extends AbstractRestController<User> {

    private static final AbstractService service = new UserService();

    public UserController() {
        super(service, User.class);
    }

    @POST
    @Path(value = "/login")
    public Response login(String json) {
        Gson gson = new GsonBuilder().create();
        Login login = gson.fromJson(json, Login.class);
        UserService userService = new UserService();
        boolean result;
        try {
            result = userService.login(login);
        } catch (SQLException ex) {
            Logger.getLogger(CityService.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(500).entity("Error occurred").build();
        }
        if (result) {
            return Response.status(200).entity("Login Successful").build();
        } else {
            return Response.status(401).entity("Incorrect username or password").build();
        }
    }
}
