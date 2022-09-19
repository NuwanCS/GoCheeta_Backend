package com.nuwan.gocheeta.db;

import com.nuwan.gocheeta.model.City;
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
public class CityDBUtils implements AbstractDbUtil<City> {

    @Override
    public City getOne(Long id) throws SQLException {
        City city = null;
        String query = "select * from city where id= ? and status='Active'";
        Connection con = DatabaseConnection.getConnection();
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                city = new City(rs);
            }
        }
        return city;
    }

    @Override
    public List<City> getAll() throws SQLException {
        List<City> citys = new ArrayList<>();
        Connection con = DatabaseConnection.getConnection();
        String query = "select * from city where status='Active'";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                City city = new City(rs);
                citys.add(city);
            }
        }
        return citys;
    }

    @Override
    public boolean add(City city) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "INSERT INTO city "
                + "(`name`,`status`) "
                + "VALUES (?,?,)";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setString(1, city.getName());
            ps.setString(2, city.getStatus());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public boolean update(City city) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "update city set status= ? where id = ?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setString(1, city.getStatus());
            ps.setLong(2, city.getId());
            int rows = ps.executeUpdate();

            return rows > 0;
        }
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "delete from city where id =?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setLong(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
}
