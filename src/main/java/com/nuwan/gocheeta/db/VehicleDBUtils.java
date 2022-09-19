package com.nuwan.gocheeta.db;

import com.nuwan.gocheeta.model.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nuwan
 */
public class VehicleDBUtils implements AbstractDbUtil<Vehicle> {

    @Override
    public Vehicle getOne(Long id) throws SQLException {
        Vehicle vehicle = null;
        Connection con = DatabaseConnection.getConnection();
        String query
                = "select * from vehicle where id= ? and status='Active'";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vehicle = new Vehicle(rs);
            }
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> getAll() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        Connection con = DatabaseConnection.getConnection();
        String query = "select * from vehicle where status='Active'";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vehicle vehicle = new Vehicle(rs);
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    @Override
    public boolean add(Vehicle vehicle) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "INSERT INTO vehicle "
                + "(`name`,`status`) "
                + "VALUES (?,?,)";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setString(1, vehicle.getName());
            ps.setString(2, vehicle.getStatus());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public boolean update(Vehicle vehicle) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "update vehicle set status= ? where id = ?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setString(1, vehicle.getStatus());
            ps.setLong(2, vehicle.getId());
            int rows = ps.executeUpdate();

            return rows > 0;
        }
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "delete from vehicle where id =?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setLong(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
}
