package com.nuwan.gocheeta.db;

import com.nuwan.gocheeta.model.VehicleCategory;
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
public class VehicleCategoryDBUtils implements AbstractDbUtil<VehicleCategory> {

    @Override
    public VehicleCategory getOne(Long id) throws SQLException {
        VehicleCategory vehicleCategory = null;
        Connection con = DatabaseConnection.getConnection();
        String query
                = "select * from vehicle_cat where id= ? and status='Active'";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vehicleCategory = new VehicleCategory(rs);
            }
        }
        return vehicleCategory;
    }

    @Override
    public List<VehicleCategory> getAll() throws SQLException {
        List<VehicleCategory> vehicleCategorys = new ArrayList<>();
        Connection con = DatabaseConnection.getConnection();
        String query = "select * from vehicle_cat where status='Active'";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                VehicleCategory vehicleCategory = new VehicleCategory(rs);
                vehicleCategorys.add(vehicleCategory);
            }
        }
        return vehicleCategorys;
    }

    @Override
    public boolean add(VehicleCategory vehicleCategory) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "INSERT INTO vehicle_cat "
                + "(`name`,`status`) "
                + "VALUES (?,?,)";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setString(1, vehicleCategory.getName());
            ps.setString(2, vehicleCategory.getStatus());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public boolean update(VehicleCategory vehicleCategory) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "update vehicle_cat set status= ? where id = ?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setString(1, vehicleCategory.getStatus());
            ps.setLong(2, vehicleCategory.getId());
            int rows = ps.executeUpdate();

            return rows > 0;
        }
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "delete from vehicle_cat where id =?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setLong(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
}
