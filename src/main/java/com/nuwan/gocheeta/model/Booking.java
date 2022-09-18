package com.nuwan.gocheeta.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Nuwan
 */
public class Booking extends BaseEntity{
    private Date createdDate;
    private Long customer;
    private Long driver;
    private Long fromStreet;
    private Long toStreet;
    private Long vehicleId;
    private Double cost;

    public Booking() {
    }

    public Booking(Long id, Date createdDate, Long customer, Long driver, Long fromStreet, Long toStreet, Long vehicleId, Double cost, String status) {
        this.id = id;
        this.createdDate = createdDate;
        this.customer = customer;
        this.driver = driver;
        this.fromStreet = fromStreet;
        this.toStreet = toStreet;
        this.vehicleId = vehicleId;
        this.cost = cost;
        this.status = status;
    }


    public Booking(ResultSet resultSet) throws SQLException {
        this.id= resultSet.getLong("id");
        this.createdDate = resultSet.getDate("created_date"); 
        this.customer = resultSet.getLong("customer");
        this.driver = resultSet.getLong("driver");
        this.fromStreet = resultSet.getLong("from_street");
        this.toStreet = resultSet.getLong("to_street");
        this.vehicleId = resultSet.getLong("vehicle_id");
        this.cost = resultSet.getDouble("cost");
        this.status = resultSet.getString("status");
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public Long getDriver() {
        return driver;
    }

    public void setDriver(Long driver) {
        this.driver = driver;
    }

    public Long getFromStreet() {
        return fromStreet;
    }

    public void setFromStreet(Long fromStreet) {
        this.fromStreet = fromStreet;
    }

    public Long getToStreet() {
        return toStreet;
    }

    public void setToStreet(Long toStreet) {
        this.toStreet = toStreet;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
