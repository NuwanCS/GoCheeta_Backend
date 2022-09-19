package com.nuwan.gocheeta.controllers;

import com.nuwan.gocheeta.services.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nuwan.gocheeta.model.BaseEntity;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nuwan
 */
public abstract class AbstractRestController<T extends BaseEntity> {

    private final AbstractService utils;
    private final  Class<T> clazz;

    public AbstractRestController(AbstractService utils,  Class<T> clazz) {
        this.utils = utils;
        this.clazz = clazz;
    }

    @GET
    public Response getAll() {
        try {
            return Response.ok(utils.getAll()).build();
        } catch (SQLException ex) {
            Logger.getLogger(AbstractRestController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(500).entity("Error occurred").build();
        }
    }

    @GET
    @Path(value = "/{id}")
    public Response getOne(@PathParam(value = "id") Long id) {
        try {
            return Response.ok(utils.getOne(id)).build();
        } catch (SQLException ex) {
            Logger.getLogger(AbstractRestController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(500).entity("Error occurred").build();
        }
    }

    @POST
    public Response add(String json) {
        Gson gson = new GsonBuilder().create();
        T t = gson.fromJson(json, clazz);
        boolean result;
        try {
            result = utils.add(t);
        } catch (SQLException ex) {
            Logger.getLogger(AbstractRestController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(500).entity("Error occurred").build();
        }
        if (result) {
            return Response.status(201).entity("Successfully added").build();
        } else {
            return Response.status(500).entity("Error occurred").build();
        }
    }

    @PUT
    public Response update(String json) {
        Gson gson = new GsonBuilder().create();
        T t = gson.fromJson(json, clazz);
        boolean result;
        try {
            result = utils.update(t);
        } catch (SQLException ex) {
            Logger.getLogger(AbstractRestController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(500).entity("Error occurred").build();
        }
        if (result) {
            return Response.status(200).entity("Successfully updated").build();
        } else {
            return Response.status(500).entity("Error occurred").build();
        }
    }

    @DELETE
    @Path(value = "/{id}")
    public Response delete(@PathParam(value = "id") Long id) {
        boolean result;
        try {
            result = utils.delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(AbstractRestController.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(500).entity("Error occurred").build();
        }
        if (result) {
            return Response.status(200).entity("Successfully deleted").build();
        } else {
            return Response.status(500).entity("Error occurred").build();
        }
    }

}
