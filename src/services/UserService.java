/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IUserService;
import java.sql.Connection;
import models.User;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import technique.DataSource;
//import utils.BCrypt;

/**
 *
 * @author YACINE
 */
public class UserService implements IUserService {

    Connection connection;
    public static User userStatic = null;

    public UserService() {
        connection = DataSource.getInstance().getConnection();
    }

    
    
    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String req = "select * from user";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user;
                user = new User(resultSet.getInt("id_user"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("cin"),
                        resultSet.getDate("datenaissance"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("numtelephone"),
                        resultSet.getString("adresse"),
                        resultSet.getDate("dateajout"),
                        resultSet.getString("adresse"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserById(Integer i) {
        String req = "select * from user where id_user=?";
        User u = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, i);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                u = new User(resultSet.getInt("id_user"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("cin"),
                        resultSet.getDate("datenaissance"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("numtelephone"),
                        resultSet.getString("adresse"),
                        resultSet.getDate("dateajout"),
                        resultSet.getString("role"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return u;
    }
    
    public User Login_User(String Username,String Password) {
        String req = "select * from user where username=? and password=?";
        User u = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, Username);
            preparedStatement.setString(2, Password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                u = new User(resultSet.getInt("id_user"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("cin"),
                        resultSet.getDate("datenaissance"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("numtelephone"),
                        resultSet.getString("adresse"),
                        resultSet.getDate("dateajout"),
                        resultSet.getString("role"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return u;
    }

    

    

}

