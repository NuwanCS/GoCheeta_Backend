package com.nuwan.gocheeta.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nuwan
 */
public class Vehicle extends BaseEntity{
    private String name;
    private String number;
    private String color;
    private String year;
    private Long vehicleCatId;

    public Vehicle(ResultSet rs) throws SQLException {
        this.id = rs.getLong("id");
        this.name = rs.getString("name");
        this.number = rs.getString("number");
        this.color = rs.getString("color");
        this.year = rs.getString("year");
        this.vehicleCatId = rs.getLong("vehicle_cat_id");
        this.status = rs.getString("status");
    }

    public Vehicle(Long id, String name, String number, String color, String year, Long vehicleCatId, String status) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.color = color;
        this.year = year;
        this.vehicleCatId = vehicleCatId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Long getVehicleCatId() {
        return vehicleCatId;
    }

    public void setVehicleCatId(Long vehicleCatId) {
        this.vehicleCatId = vehicleCatId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
