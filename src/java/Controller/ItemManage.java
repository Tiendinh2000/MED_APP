/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.Controller;

/**
 *
 * @author nobody
 */
import java.Model.Item;
import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemManage {

    public static List<Item> ItemList() {

        List<Item> itemlist = new ArrayList<>();
        Connection connection = null;
        Statement statement = null; // it is data
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");
            if (connection != null) {
                System.out.println("Connect success!");
            }
            String sql = "select * from item";

            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                Item i = new Item(result.getString("id"),
                        result.getString("name"),
                        result.getInt("price"),
                        result.getBytes("image"));
                itemlist.add(i);
            }

            // showResutl(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return itemlist;
    }

    public static void add(Item item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");

            String sql = "insert into item(id,name, price,image) values(? ,?, ?,?)";
            statement = connection.prepareCall(sql);
            
           
            statement.setString(1, item.getId());
            statement.setString(2, item.getName());
            statement.setInt(3, item.getPrice());
            statement.setBytes(4,item.getImage());

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

    }

    public static void update(Item item) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");

            String sql = "update item set name=?,price=?,image=? where id = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, item.getName());
            statement.setInt(2, item.getPrice());
            statement.setBytes(3,item.getImage());
            statement.setString(4, item.getId());
            

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

    }

    public static void delete(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");

            String sql = "delete from item where id =?";
            statement = connection.prepareCall(sql);
            statement.setString(1, id);

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

    }

    public static List<Item> findById(String id) {
        List<Item> studentList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");

            String sql = "select * from item where id= ?";
            statement = connection.prepareCall(sql);
            statement.setString(1,  id );

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Item item = new Item(resultSet.getString("id"),
                resultSet.getString("name"),
                resultSet.getInt("price"),
                        resultSet.getBytes("image")
                );
                studentList.add(item);
            }
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

        return studentList;
    }

}
