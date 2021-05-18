/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.Controller;

import java.Model.Order;
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
public class OrderManage {
    public static List<Order> OrderList() {

        List<Order> orderlist = new ArrayList<>();
        Connection connection = null;
        Statement statement = null; // it is data
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");
            if (connection != null) {
                System.out.println("Connect success!");
            }
            String sql = "select * from allorder";

            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                
                Order o = new Order(result.getInt("id"),
                        result.getString("product_id"),
                        result.getString("address"),
                        result.getString("time"),
                        result.getInt("quantity")
                        , result.getString("Status"));
                orderlist.add(o);
            }

            // showResutl(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orderlist;
    }

    public static void add(Order order) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");

            String sql = "insert into allorder(product_id,address, time, quantity,status) values(?,? ,?, ?,?)";
            statement = connection.prepareCall(sql);

            statement.setString(1, order.getProduct_id());
            statement.setString(2, order.getAddress());
            statement.setString(3, order.getTime());
            statement.setInt(4,order.getQuantity());
            statement.setString(5,order.getStatus());

            statement.execute();
        } catch (SQLException e) {
            Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static void deliverOrder(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");

            String sql = "update allorder set status=? where id=?";
            statement = connection.prepareCall(sql);

            statement.setString(1, "<html> <font color='orange'>delivering</font></html>");
            statement.setInt(2, id);
           

            statement.execute();
        } catch (SQLException e) {
            Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

     public static void receiveOrder(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");

            String sql = "update allorder set status=?   where id = ?";
            statement = connection.prepareCall(sql);

            statement.setString(1, "<html> <font color='green'>received</font></html>");
            statement.setInt(2, id);
           

            statement.execute();
        } catch (SQLException e) {
            Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    
    
    
    public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");

            String sql = "delete from allorder where id =?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException e) {
            Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
//
//    public static List<Order> findById(String id) {
//        List<Order> studentList = new ArrayList<>();
//
//        Connection connection = null;
//        PreparedStatement statement = null;
//
//        try {
//
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sad", "root", "");
//
//            String sql = "select * from order where id= ?";
//            statement = connection.prepareCall(sql);
//            statement.setString(1,  id );
//
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                Order order = new Order(resultSet.getString("id"),
//                resultSet.getString("name"),
//                resultSet.getInt("price"));
//                studentList.add(order);
//            }
//        } catch (SQLException e) {
//            Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, e);
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(OrderManage.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//
//        return studentList;
//    }
}
