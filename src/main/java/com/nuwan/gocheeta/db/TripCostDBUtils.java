package com.nuwan.gocheeta.db;

import com.nuwan.gocheeta.model.TripCost;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nuwan
 */
public class TripCostDBUtils implements AbstractDbUtil<TripCost> {

    @Override
    public TripCost getOne(Long id) throws SQLException {
        TripCost tripCost = null;
        Connection con = DatabaseConnection.getConnection();
        String query
                = "select * from trip_cost where id= ? and status= 'Active'";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tripCost = new TripCost(rs);
            }
        }
        return tripCost;
    }

    @Override
    public List<TripCost> getAll() throws SQLException {
        List<TripCost> tripCosts = new ArrayList<>();
        Connection con = DatabaseConnection.getConnection();
        String query = "select * from trip_cost where status= 'Active'";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TripCost tripCost = new TripCost(rs);
                tripCosts.add(tripCost);
            }
        }
        return tripCosts;
    }

    @Override
    public boolean add(TripCost tripCost) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "INSERT INTO trip_cost (`created_date`,`from_street`,`to_street`,`cost`,`status`)\n"
                + "VALUES (?,?,?,?,?)";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setTimestamp(1, new Timestamp(new Date().getTime()));
            ps.setLong(2, tripCost.getFromStreet());
            ps.setLong(3, tripCost.getToStreet());
            ps.setDouble(4, tripCost.getCost());
            ps.setString(5, tripCost.getStatus());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public boolean update(TripCost tripCost) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "update trip_cost set status= ? where id = ?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setString(1, tripCost.getStatus());
            ps.setLong(2, tripCost.getId());
            int rows = ps.executeUpdate();

            return rows > 0;
        }
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "delete from trip_cost where id =?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setLong(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
}
