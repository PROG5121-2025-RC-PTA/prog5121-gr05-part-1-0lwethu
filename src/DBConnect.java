/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author RC_Student_lab
 */
public class DBConnect {
    public static Connection connectionDB() {
        try{
            //Load the JDBC driver (for MySQL)
            Class.forName("com.mysql.cj.jdbc.Driver");
       
            //update URLR,username, and password to match your DB setup
        String url = "jdbc:mysql://localhost:3306/my_database";
        String user = "root";
        String password ="Olwethu@17";
      
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException ex){
                ex.printStackTrace();
                return null;
                }
            }
    }


