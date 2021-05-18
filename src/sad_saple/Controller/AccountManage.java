/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sad_saple.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sad_saple.Model.Account;

/**
 *
 * @author nobody
 */
public class AccountManage {
    
    public static boolean findACC(Account a) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //create connect
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");
            
            //check if input name is correct 
            String sql = "select * from acc where name =? and password=? and role=?";
            statement = connection.prepareCall(sql);
            statement.setString(1,  a.getName() );
            statement.setString(2,  a.getPW() );
            statement.setString(3, a.getRole());

            ResultSet result = statement.executeQuery();
            if(result.next())
                return true;
            else
                return false;                  
                         
        } catch (SQLException e) {
            Logger.getLogger(ItemManage.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ItemManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ItemManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return true;
    }
    
    
    
    
     public static boolean add(String newName,String newPW,String role) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");
            //check
            String check="select * from acc where name =?";
            statement = connection.prepareCall(check);
            statement.setString(1,  newName );

            ResultSet result = statement.executeQuery();
            if (result.next()){
                //name is duplicate
              return false;
              
            }
            
            //end check
            
            String sql = "insert into acc(name, password,role) values(?, ? ,?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, newName);
            statement.setString(2, newPW);
            statement.setString(3, role);

            statement.execute();
        } catch (SQLException e) {
            Logger.getLogger(ItemManage.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ItemManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ItemManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       return true;
    }
         
     
    
}
