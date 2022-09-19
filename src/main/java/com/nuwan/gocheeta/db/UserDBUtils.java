package com.nuwan.gocheeta.db;

import com.nuwan.gocheeta.model.Login;
import com.nuwan.gocheeta.model.User;
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
public class UserDBUtils implements AbstractDbUtil<User> {

    @Override
    public User getOne(Long id) throws SQLException {
        User user = null;
        Connection con = DatabaseConnection.getConnection();
        String query
                = "select * from user where id= ? and status='Active'";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs);
            }
        }
        return user;
    }
    
     public User login(Login login) throws SQLException {
        User user = null;
        Connection con = DatabaseConnection.getConnection();
        String query
                = "select * from user where email= ? and password=? and status='Active'";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {

            ps.setString(1, login.getUsername());
            ps.setString(2, login.getPassword());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs);
            }
        }
        return user;
    }


    @Override
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection con = DatabaseConnection.getConnection();
        String query = "select * from user where status='Active'";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User(rs);
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public boolean add(User user) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "INSERT INTO `user` (`fname`,`lname`,`email`,`contact`,`address`,`type`,`status`,`password`)\n"
                + "VALUES (?,?,?,?,?,?,?,?);";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setString(1, user.getfName());
            ps.setString(2, user.getlName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getContact());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getType());
            ps.setString(7, user.getStatus());
            ps.setString(8, user.getPassword());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    @Override
    public boolean update(User user) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "update user set status= ? where id = ?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setString(1, user.getStatus());
            ps.setLong(2, user.getId());
            int rows = ps.executeUpdate();

            return rows > 0;
        }
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        String query = "delete from user where id =?";
        try ( PreparedStatement ps
                = con.prepareStatement(query)) {
            ps.setLong(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
}
