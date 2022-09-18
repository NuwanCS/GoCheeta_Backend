package com.nuwan.gocheeta.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nuwan
 */
public class VehicleCategory extends BaseEntity{
    private String name;

    public VehicleCategory() {
    }

    public VehicleCategory(ResultSet rs) throws SQLException {
        this.id = rs.getLong("id");
        this.name = rs.getString("name");
        this.status =rs.getString("status");
    }

    public VehicleCategory(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status =status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
