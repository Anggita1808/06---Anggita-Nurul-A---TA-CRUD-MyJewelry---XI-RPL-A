/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.anggita.jewelry.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ZenBook
 */
public class ConnectionDB {

    static String DB="jdbc:mysql://localhost/my_jewelry"; // my_jewelry database
    static String user="root"; // user database
    static String pass=""; // password database
    private static Connection con;

    public static Connection getConnection() throws SQLException {
        if(con==null){
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                con = (Connection) DriverManager.getConnection(DB,user,pass);
            } catch (Exception e) {
                System.out.println("Database connection is failed");
            }
        }

       return con;
    }
}
