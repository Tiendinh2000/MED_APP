/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.Controller;

import java.Model.Disease;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nobody
 */
public class DiseaseManage {
    
    
    public static List<Disease> DiseaseList() {

        List<Disease> diseaseList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null; // it is data
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");
            if (connection != null) {
                System.out.println("Connect success!");
            }
            String sql = "select * from disease";

            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Disease i = new Disease(result.getInt("id"),
                        result.getString("name"),
                        result.getString("accountname"),
                        result.getString("comment"));
                diseaseList.add(i);
            }

            // showResutl(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return diseaseList;
    }

    public static void add(Disease disease) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");

            String sql = "insert into disease(name,accountname) values(?,?)";
            statement = connection.prepareCall(sql);
            
           
            statement.setString(1, disease.getName());
            statement.setString(2, disease.getAccountName());
            //statement.setString(3, disease.getComment());
            

            statement.execute();
        } catch (SQLException e) {
            Logger.getLogger(DiseaseManage.class.getName()).log(Level.SEVERE, null, e);
            
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiseaseManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiseaseManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static void update(String newComment,int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");

            String sql = "update disease set comment=? where id = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, newComment);
            
            statement.setInt(2, id);

            statement.execute();
        } catch (SQLException e) {
            Logger.getLogger(DiseaseManage.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiseaseManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DiseaseManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    
    
    
    
    
    
}
