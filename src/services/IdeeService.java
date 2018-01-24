/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IIdeeService;
import java.sql.Connection;
import java.sql.Date;
import models.User;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Idee;

import technique.DataSource;
//import utils.BCrypt;

/**
 *
 * @author YACINE
 */
public class IdeeService implements IIdeeService {

    Connection connection;
    public static User userStatic = null;

    public IdeeService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public List<Idee> getAll() {
        List<Idee> ideas = new ArrayList<>();
        String req = "select * from idee";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Idee idea;
                idea = new Idee(resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("titre"),
                        resultSet.getString("domaine"),
                        resultSet.getString("description"),
                        resultSet.getDate("date_ajout"),
                        resultSet.getInt("prix"),
                        resultSet.getString("path_doc"),
                        resultSet.getString("path_img"),
                        resultSet.getString("etat"));
                ideas.add(idea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ideas;
    }

    @Override
    public Idee getIdeeById(Integer i) {
        String req = "select * from idee where id=?";
        Idee idea = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, i);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                idea = new Idee(resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("titre"),
                        resultSet.getString("domaine"),
                        resultSet.getString("description"),
                        resultSet.getDate("date_ajout"),
                        resultSet.getInt("prix"),
                        resultSet.getString("path_doc"),
                        resultSet.getString("path_img"),
                        resultSet.getString("etat"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return idea;
    }
    
    
    @Override
    public List<Idee> getIdeesByUserId(Integer i) {
        List<Idee> ideas = new ArrayList<>();
        String req = "select * from idee where user_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, i);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Idee idea;
                idea = new Idee(resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("titre"),
                        resultSet.getString("domaine"),
                        resultSet.getString("description"),
                        resultSet.getDate("date_ajout"),
                        resultSet.getInt("prix"),
                        resultSet.getString("path_doc"),
                        resultSet.getString("path_img"),
                        resultSet.getString("etat"));
                ideas.add(idea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ideas;
    }
    
    @Override
    public List<Idee> getChecked() {
        List<Idee> ideas = new ArrayList<>();
        String req = "select * from idee where etat='OK'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Idee idea;
                idea = new Idee(resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("titre"),
                        resultSet.getString("domaine"),
                        resultSet.getString("description"),
                        resultSet.getDate("date_ajout"),
                        resultSet.getInt("prix"),
                        resultSet.getString("path_doc"),
                        resultSet.getString("path_img"),
                        resultSet.getString("etat"));
                ideas.add(idea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ideas;
    }
    @Override
    public List<Idee> getNonChecked() {
        List<Idee> ideas = new ArrayList<>();
        String req = "select * from idee where etat='NON'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Idee idea;
                idea = new Idee(resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("titre"),
                        resultSet.getString("domaine"),
                        resultSet.getString("description"),
                        resultSet.getDate("date_ajout"),
                        resultSet.getInt("prix"),
                        resultSet.getString("path_doc"),
                        resultSet.getString("path_img"),
                        resultSet.getString("etat"));
                ideas.add(idea);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ideas;
    }

    @Override
    public void add(Idee i) {
        String req = "insert into idee ("
                + "user_id,"
                + "titre,"
                + "domaine,"
                + "description,"
                + "date_ajout,"
                + "prix,"
                + "path_doc,"
                + "path_img,"
                + "etat) values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, i.getUser_id());
            preparedStatement.setString(2, i.getTitre());
            preparedStatement.setString(3, i.getDomaine());
            preparedStatement.setString(4, i.getDescription());
            preparedStatement.setDate(5, i.getDate_ajout());
            preparedStatement.setInt(6, i.getPrix());
            preparedStatement.setString(7, i.getPath_doc());
            preparedStatement.setString(8, i.getPath_img());
            preparedStatement.setString(9, "NON");
            preparedStatement.executeUpdate();
            System.out.println("USER ADDED");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String req = "delete from  idee where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Idee delete");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Idee i) {
        String req = "update idee set user_id=?, titre=?,domaine=?, description=?, date_ajout=?, prix=?, path_doc=?, path_img=? where id = ?";

        PreparedStatement preparedStatement;
        try {
            System.out.println(req);
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, i.getUser_id());
            preparedStatement.setString(2, i.getTitre());
            preparedStatement.setString(3, i.getDomaine());
            preparedStatement.setString(4, i.getDescription());
            preparedStatement.setDate(5, i.getDate_ajout());
            preparedStatement.setInt(6, i.getPrix());
            preparedStatement.setString(7, i.getPath_doc());
            preparedStatement.setString(8, i.getPath_img());
            preparedStatement.setInt(9, i.getId());
            preparedStatement.executeUpdate();
                       
            System.out.println("Idee UPDATED");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void check(Integer id) {
    String req = "update idee set etat=? where id =?";
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setString(1, "OK");
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();
                System.out.println("\n Idee CHecked !!!\n");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }    
    }

}
