package com.nuwan.gocheeta.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nuwan
 */
public class User extends BaseEntity{
    private String fname;
    private String lname;
    private String email;
    private String contact;
    private String address;
    private String type;
    private String password;

    public User(ResultSet rs) throws SQLException {
        this.id = rs.getLong("id");
        this.fname = rs.getString("fname");
        this.lname = rs.getString("lname");
        this.email = rs.getString("email");
        this.contact = rs.getString("contact");
        this.address = rs.getString("address");
        this.type = rs.getString("type");
        this.status = rs.getString("status");
        this.password = rs.getString("password");
    }

    public User(Long id, String fName, String lName, String email, String contact, String address, String type, String status, String password) {
        this.id = id;
        this.fname = fName;
        this.lname = lName;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.type = type;
        this.status = status;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fname;
    }

    public void setfName(String fName) {
        this.fname = fName;
    }

    public String getlName() {
        return lname;
    }

    public void setlName(String lName) {
        this.lname = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
