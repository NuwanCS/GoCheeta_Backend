package com.nuwan.gocheeta.db;

import com.nuwan.gocheeta.model.Booking;
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
public class BookingDBUtils implements AbstractDbUtil<Booking> {

    @Override
    public Booking getOne(Long id) throws SQLException {
        Booking booking = null;
        Connection con = DatabaseConnection.getConnection();
        String query = "select * from booking where id= ?  and status='Active'";
        try ( PreparedStatement ps = con.prepareStatement(query);) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                booking = new Booking(rs);
            }
        }
        return booking;
    }

    @Override
    public List<Booking> getAll() throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        String query = "select * from booking where status='Active'";
        Connection con = DatabaseConnection.getConnection();
        try ( PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking(rs);
                bookings.add(booking);
            }
        }
        return bookings;
    }

    @Override
    public boolean add(Booking booking) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "INSERT INTO booking "
                + "(`created_date`,`customer`,`driver`,`from_street`,`to_street`,`vehicle_id`,`cost`,`status`) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setTimestamp(1, new Timestamp(new Date().getTime()));
            ps.setLong(2, booking.getCustomer());
            ps.setLong(3, booking.getDriver());
            ps.setLong(4, booking.getFromStreet());
            ps.setLong(5, booking.getToStreet());
            ps.setLong(6, booking.getVehicleId());
            ps.setDouble(7, booking.getCost());
            ps.setString(8, booking.getStatus());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public boolean update(Booking booking) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "update booking set driver=?, vehicle_id= ?, status= ? where id = ?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {

            ps.setLong(1, booking.getDriver());
            ps.setLong(2, booking.getVehicleId());
            ps.setString(3, booking.getStatus());
            ps.setLong(4, booking.getId());
            int rows = ps.executeUpdate();

            return rows > 0;
        }
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "delete from booking where id =?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setLong(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
}
