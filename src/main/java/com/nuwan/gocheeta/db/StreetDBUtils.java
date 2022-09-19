package com.nuwan.gocheeta.db;

import com.nuwan.gocheeta.model.Street;
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
public class StreetDBUtils implements AbstractDbUtil<Street> {

    @Override
    public Street getOne(Long id) throws SQLException {
        Street street = null;
        Connection con = DatabaseConnection.getConnection();
        String query = "select * from street where id= ? and status='Active'";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                street = new Street(rs);
            }
        }
        return street;
    }

    @Override
    public List<Street> getAll() throws SQLException {
        List<Street> streets = new ArrayList<>();
        Connection con = DatabaseConnection.getConnection();
        String query = "select * from street where status='Active'";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Street street = new Street(rs);
                streets.add(street);
            }
        }
        return streets;
    }

    @Override
    public boolean add(Street street) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "INSERT INTO street "
                + "(`name`,`status`) "
                + "VALUES (?,?,)";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setString(1, street.getName());
            ps.setString(2, street.getStatus());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public boolean update(Street street) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "update street set status= ? where id = ?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setString(1, street.getStatus());
            ps.setLong(2, street.getId());
            int rows = ps.executeUpdate();

            return rows > 0;
        }
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "delete from street where id =?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setLong(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
}
