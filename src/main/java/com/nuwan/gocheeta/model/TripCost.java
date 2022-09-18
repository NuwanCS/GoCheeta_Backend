package com.nuwan.gocheeta.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Nuwan
 */
public class TripCost extends BaseEntity{
    private Date createdDate;
    private Long fromStreet;
    private Long toStreet;
    private Double cost;

    public TripCost() {
    }

    public TripCost(ResultSet rs) throws SQLException {
        this.id = rs.getLong("id");
        this.createdDate = rs.getDate("created_date");
        this.fromStreet = rs.getLong("from_street");
        this.toStreet = rs.getLong("to_street");
        this.cost = rs.getDouble("cost");
        this.status =rs.getString("status");
    }

    public TripCost(Long id, Date createdDate, Long fromStreet, Long toStreet, Double cost, String status) {
        this.id = id;
        this.createdDate = createdDate;
        this.fromStreet = fromStreet;
        this.toStreet = toStreet;
        this.cost = cost;
        this.status = status;
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
